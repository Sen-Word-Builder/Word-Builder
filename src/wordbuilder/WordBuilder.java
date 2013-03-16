/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import java.io.File;
import java.io.IOException;
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
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
      //  Properties props = System.getProperties();
    //    props.setProperty("wordnet.database.dir", "wordnet/dict"); 
      //  System.setProperty("wordnet.database.dir","../wordnet/dict");
       System.setProperty("wordnet.database.dir", "C:/Program Files (x86)/WordNet/2.1/dict");
   //     String a = System.getProperty("user.dir");
     //   a+="/WordBuilder.jar/wordnet/dict/";
      //  System.setProperty("wordnet.database.dir", a);
        ApiFetch.main(args);
        //MainPage.main(args);
     
       
    }
}
