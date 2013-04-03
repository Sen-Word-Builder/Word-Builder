/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;



import database.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mohit
 */
public class WordBuilder {

    static Signin signin=new Signin();
    static Signup signup=new Signup();
    static ForgotPassword forgotpassword=new ForgotPassword();
    static MainPage mainpage=new MainPage();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        // TODO code application logic here
      //  Properties props = System.getProperties();
     //  props.setProperty("wordnet.database.dir", "wordnet/dict"); 
        System.setProperty("wordnet.database.dir","wordnet/dict");
       //System.setProperty("wordnet.database.dir", "C:/Program Files (x86)/WordNet/2.1/dict");
   //     String a = System.getProperty("user.dir");
     //   a+="/WordBuilder.jar/wordnet/dict/";
      //  System.setProperty("wordnet.database.dir", a);
        //ApiFetch.main(args);
        //ApiFetch.getMeaning(" ","help","q");
        //MainPage.main(args);
        //ApiFetch.getHypernym("");
        //ApiFetch.getHyponym("");
        // MainPage.main(args);
        // BaseIcon.set();
       // PopUp.main(args);
     //   Signup.main(args);
      //  System.out.println(getCurrentUser());
       // PopUp a =new PopUp();
        
      



/*
 * Chandra's code....to be added later (removed for testing
        BackGround a = new BackGround();
  */

        //Database speed increased.....
        
        /*
        DatabaseOperations.init();


     
       */
        
        DatabaseOperations.init();
        WordBuilder.signin.setVisible(true);

    }
    
    
    public static String getCurrentUser()
    {
        return currentU;
    }
    public static void setCurrentUser(String user)
    {
        currentU = user;
    }
    public static MainPage getMainpage()
    {
        return mp;
    }
    public static BackGround getBackGround()
    {
        return bg;
    }
    public static Signin getSignin()
    {
        return si;
    }
    public static Signup getSignup(){
        return su;
    }
    public static DatabaseOperations getDatabaseOperations()
    {
        return dbo;
    }
    public static BaseIcon getBaseIcon()
    {
        return bi;
    }
    public static Notify getNotify()
    {
        return nt;
    }
    public static Options getOptions()
    {
        return ops;
    }
    
    private static Signin si;
    private static Signup su;
    private static DatabaseOperations dbo;
    private static DatabaseOperationsTest dbot;
    private static String currentU;
    private static MainPage mp;
    private static BaseIcon bi ;
    private static BackGround bg;
    private static Notify nt;
    private static Options ops;
}
