/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;

/**
 *
 * @author Mohit
 */
public class WordBuilder {

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
        MainPage.main(args);
        
        
     
       
    }
    
    public static String getCurrentUser()
    {
        return currentU;
    }
    public static void setCurrentUser(String user)
    {
        currentU = user;
    }
    
    public  static String currentU;
}
