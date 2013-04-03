/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;



import database.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    private static String currentU;
    public static BaseIcon bi ;
    public static BackGround bg;
    public static Notify nt;
    public static Options ops;
}
