/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;



import database.*;

import java.awt.Font;

import java.awt.SplashScreen;


import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import quiz_retention.QuizRD;

/**
 *
 * @author Mohit
 */
public class WordBuilder {


   public  static Signin signin=new Signin();
   public  static Signup signup=new Signup();
  public   static ForgotPassword forgotpassword=new ForgotPassword();
   public  static MainPage mainpage=new MainPage();

   public  static  Font font = new Font("Cambria", Font.BOLD, 12);
   
   

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

        System.setProperty("wordnet.database.dir","wordnet/dict");mainpage.setFont(font);
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
                
      //        quiz.setVisible(true);
                
        //Signin in = new Signin();
        //in.setVisible(true);
     //   ab = new MainPage();
      // ab.setVisible(true);
    //   bi = new BaseIcon();
        Options op = new Options();

     
      
        DatabaseOperations.init();

        WordBuilder.signin.setVisible(true);
    
        
      /*  QuizRD quiz=new QuizRD();

      quiz.setVisible(true);
      quiz.startQuiz(); */
      
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
    public static SplashScreen loadingScreen;
    private static String currentU;
    public static BaseIcon bi ;
    public static BackGround bg;
    public static Notify nt;
    public static Options ops;
}
