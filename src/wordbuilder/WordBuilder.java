/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;



import database.*;
import java.awt.SplashScreen;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import quiz_retention.QuizRD;
import static wordbuilder.Splash.loadingScreen;
/**
 *
 * @author Mohit
 */
public class WordBuilder {

   
    static Signin signin=new Signin();
    static Signup signup=new Signup();
    static ForgotPassword forgotpassword=new ForgotPassword();
    static MainPage mainpage=new MainPage();
    
//    static Quiz quiz=new Quiz();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
       
        loadingMethod();
        
        if (loadingScreen != null) {
            loadingScreen.close();
        }
     //  props.setProperty("wordnet.database.dir", "wordnet/dict"); 
        System.setProperty("wordnet.database.dir","wordnet/dict");
       
        
                new Thread() 
                {
                @Override
                public void run() {
                    try {
                        BackGround a = new BackGround();
                    } catch (Exception e) {
                    }
                }
        
                }
                        .start();
                
      //          quiz.setVisible(true);
                
        //Signin in = new Signin();
        //in.setVisible(true);
     //   ab = new MainPage();
      // ab.setVisible(true);
    //   bi = new BaseIcon();
        Options op = new Options();

     

  
        DatabaseOperations.init();

      //  WordBuilder.signin.setVisible(true);
      
        WordBuilder.setCurrentUser("vaibhav");
        QuizRD quiz=new QuizRD();
      quiz.setVisible(true);
      quiz.startQuiz(); 
      

    }
    
    
    public static String getCurrentUser()
    {
        return currentU;
    }
    public static void setCurrentUser(String user)
    {
        currentU = user;
    }
    
     public static void loadingMethod() {
        loadingScreen = SplashScreen.getSplashScreen();
        if (loadingScreen !=null){
            try {
                Thread.sleep(5000);
                // if there are any problems displaying the splash this will be null
            } catch (InterruptedException ex) {
                Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        }
    }
    
    private static String currentU;
    public static BaseIcon bi ;
    public static BackGround bg;
    public static Notify nt;
    public static Options ops;
}
