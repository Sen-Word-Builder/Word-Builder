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
