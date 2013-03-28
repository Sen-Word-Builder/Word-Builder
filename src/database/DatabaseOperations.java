/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


/**
 *
 * @author Mohit
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Mohit
 */
public class DatabaseOperations {

    protected Connection db_con;
/*    private String driver = "org.postgresql.Driver";
    private String db_url = "jdbc:postgresql://10.100.71.21/";
    private String db_user = "201001010";
    private String db_pwd = "201001010";
    private String search_path = "sen";
*/
    //checked and working
    public boolean createUser(String name, String uid, String pass, String ques, String answer) throws SQLException, ClassNotFoundException {
        db_con = createConnection();
        System.out.println(db_con);
        Statement stmt = db_con.createStatement();
     //   stmt.executeUpdate("set search_path to " + search_path + ";");

        ResultSet rs = stmt.executeQuery("SELECT user_id from user_details "
                + "where user_id='" + uid + "'");

        if (rs.next()) {
              db_con.close();

            return false;
        } else {
            stmt.executeUpdate("insert into user_details values ('" + uid + "','" + name + "','" + pass + "','" + ques
                    + "','" + answer + "','" + new Date(System.currentTimeMillis()) + "')");

            db_con.close();
            return true;
        }

    }

    //checked and working
    public boolean checkLogin(String uid, String pswd) throws SQLException, ClassNotFoundException {
        db_con = createConnection();

        Statement stmt = db_con.createStatement();
   //     stmt.executeUpdate("set search_path to " + search_path + ";");

        ResultSet rs = stmt.executeQuery("SELECT user_id,pswd from user_details "
                + "where user_id='" + uid + "' and pswd='" + pswd + "'");
        if (rs.next()) {
            db_con.close();
            return true;
        } else {
            db_con.close();
            return false;
        }

    }

    //tested and working fine
    public ArrayList<String> recoverPassword(String uid) throws SQLException, ClassNotFoundException{
         db_con = createConnection();

         ArrayList<String> list=new ArrayList<>();
         
        Statement stmt = db_con.createStatement();
   
        ResultSet rs = stmt.executeQuery("SELECT pswd,security_question,security_answer from user_details "
                + "where user_id='" + uid + "'");
        
        while (rs.next()) {
            list.add(rs.getString("pswd"));
            list.add(rs.getString("security_question"));
            list.add(rs.getString("security_answer"));
        }
        db_con.close();
        
        return list;
    }
    
    //checked and working
    public ArrayList<String> returnDate(String uid,String word) throws SQLException, ClassNotFoundException{
         db_con = createConnection();

         ArrayList<String> dates=new ArrayList<String>();
         
        Statement stmt = db_con.createStatement();
   //     stmt.executeUpdate("set search_path to " + search_path + ";");

        ResultSet rs = stmt.executeQuery("SELECT first_searched,last_searched from has_searched "
                + "where user_id='" + uid + "' and word='" + word + "'");
        
        while(rs.next()){
            String date1=rs.getString("first_searched");
            String date2=rs.getString("last_searched");
            
            dates.add(date1);
            dates.add(date2);
        }
        db_con.close();
        
        return dates;
    }
    //checked and working
    public String getRandomWord(String uid) throws SQLException, ClassNotFoundException{
        String word="";
        int count=0;
         db_con = createConnection();
             Statement stmt = db_con.createStatement();
  
            ResultSet rs = stmt.executeQuery("SELECT * from has_searched "
                + "where user_id='" + uid + "'");
            
        while (rs.next()) {
           count++;
        }
        //  System.out.println("count"+count);
          
          if(count==0) {
              db_con.close();
              return null;
          }
          
          int random=1+(int)(Math.random()*count);
          
       //   System.out.println("random"+random);
          
            rs = stmt.executeQuery("SELECT word from has_searched "
                + "where user_id='" + uid + "'");
           
            
            
            int i=1;
            while (rs.next()) {
            if(random==i){
                word=rs.getString("word");
            }
            i++;
        }
       //   System.out.println(word);
            
            db_con.close();
      return word;
    }
    
    //very carefully checked and working absolutely fine
    public void updateHasSearched(ArrayList<String> list) throws SQLException, ClassNotFoundException{
        String uid=list.get(0);
        String word=list.get(1);
        int frequency=Integer.parseInt(list.get(2));
        int count=0;
         db_con = createConnection();
        
          Statement stmt = db_con.createStatement();
  
          Date date=new Date(System.currentTimeMillis());
            ResultSet rs = stmt.executeQuery("SELECT count from has_searched "
                + "where user_id='" + uid + "' and word='"+word+"'");
            
            if(rs.next())
            {
                count=rs.getInt("count");
                count++;
                stmt.executeUpdate("UPDATE has_searched " + "SET count=" + count +
                    ",last_searched='"+date+"' where user_id='"+uid+"' and word='"+word+"'");
            
            }
            else{
                count++;
                rs=stmt.executeQuery("SELECT word,frequency from words "
                + "where word='" + word + "'");
                
                if(rs.next()){
                 stmt.executeUpdate("insert into has_searched values"
                         + " ('"+uid+"','"+word+"','"+date+"','"+date+"',"+count+")");
                }
                else{
                    stmt.executeUpdate("insert into words values('"
                            +word+ "',"+frequency+")");
                     stmt.executeUpdate("insert into has_searched values"
                         + " ('"+uid+"','"+word+"','"+date+"','"+date+"',"+count+")");
                }
            }
         
         db_con.close();
    }
    
    //checked and working
    public int returnCount(String uid,String word) throws SQLException, ClassNotFoundException{
         db_con = createConnection();

         int count=0;
         
        Statement stmt = db_con.createStatement();
   //     stmt.executeUpdate("set search_path to " + search_path + ";");

        ResultSet rs = stmt.executeQuery("SELECT count from has_searched "
                + "where user_id='" + uid + "' and word='" + word + "'");
        
        while(rs.next()){
            String count1=rs.getString("count");
            count=Integer.parseInt(count1);
          }
        db_con.close();
        
        return count;
    }
    
    public ArrayList<String> getAllWordsSearched(String uid) throws SQLException, ClassNotFoundException{
         db_con = createConnection();

         ArrayList<String> all=new ArrayList<String>();
         
        Statement stmt = db_con.createStatement();
   //     stmt.executeUpdate("set search_path to " + search_path + ";");

        ResultSet rs = stmt.executeQuery("SELECT word,first_searched,last_searched,coount from has_searched "
                + "where user_id='" + uid + "'");
        
        while(rs.next()){
            String word=rs.getString("word");
            String date1=rs.getString("first_searched");
            String date2=rs.getString("last_searched");
            String count=rs.getString("count");
            
            all.add(word);
            all.add(date1);
            all.add(date2);
            all.add(count);
        }
        db_con.close();
        
        return all;
    }
    
    //checked and working fine
    public ArrayList<String> showHistory(String uid) throws SQLException, ClassNotFoundException{
          db_con = createConnection();

         ArrayList<String> all=new ArrayList<String>();
         
        Statement stmt = db_con.createStatement();
   
        ResultSet rs = stmt.executeQuery("SELECT word from has_searched "
                + "where user_id='" + uid + "'");
        
        while (rs.next()) {
            all.add(rs.getString("word"));
        }
        
        db_con.close();
        return all;
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseOperations d = new DatabaseOperations();
        System.out.println(d.returnDate("trial0", "abc"));
        System.out.println(d.returnCount("trial0", "abc"));
    }

    private Connection createConnection() throws SQLException, ClassNotFoundException {
     //   Class.forName(driver);
       // Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
        // Statement stmt_search_path = db_con.createStatement();
        // stmt_search_path.executeUpdate("set search_path to "+search_path+";");
        
         Properties properties = System.getProperties();
          System.setProperty("derby.system.home", properties.getProperty("user.dir"));
             Connection con = DriverManager.getConnection("jdbc:derby:sendb", "test", "123");
       
        return con;
    }
}
