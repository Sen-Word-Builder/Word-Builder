/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.SQLException;
import java.util.ArrayList;
import wordbuilder.ApiFetch;

/**
 *
 * @author Mohit
 */
public class DatabaseOperationsTest {
    public static void main(String args []) throws SQLException, ClassNotFoundException{
     //DatabaseOperations d = new DatabaseOperations();
       // System.out.println(d.createUser("trial0", "trial0", "trial0", "trial0", "trial0"));
         System.setProperty("wordnet.database.dir","wordnet/dict");
        DatabaseOperations.init();
       //  System.out.println(DatabaseOperations.getScoreDepth("trial0")+""+DatabaseOperations.getScoreRention("trial0")+""+DatabaseOperations.getScoreWidth("trial0"));
        
        
        System.out.println(ApiFetch.getMeaning("trial0", "rain", "q"));
        System.out.println(DatabaseOperations.getLastQuizData("vaibhav"));
        //start width test
        /*
        System.out.println(DatabaseOperations.getWordsWidth());
        
        ArrayList<String> list=new ArrayList<String>();
        list=DatabaseOperations.getWordsWidth();
        int a=(int)Double.parseDouble(list.get(1));
        System.out.println(a);
        
        
         ArrayList<String> words_asked=new ArrayList<String>();
        
        int count=(list.size()/2 );
        System.out.println(count);
        int i;
        int c=0;
        
        int j=0;
        
        System.out.println(list.get(c));
        words_asked.add(list.get(c));
        System.out.println(list);
        
        words_asked.add("cat");
        words_asked.add("hat");
        
        while(j<5){
            System.out.println("words asked "+words_asked);
            c=c+2*(1+ (int)(Math.random()*11));
            while(words_asked.contains(list.get(c))){
                c++;
                c++;
                System.out.println("c is " +c);
            }
            System.out.println(list.get(c));
            System.out.println("ques is "+ ApiFetch.getMeaning("vaibhav", list.get(c), "q"));
           // System.out.println("answer is ")+;
            words_asked.add(list.get(c));
            j++;
        }
        
        System.out.println("at the end words asked are "+words_asked);
        */
        
        
        //end width
        
        
        
        
    //   System.out.println(DatabaseOperations.checkLogin("trial0", "trial0"));
      //  System.out.println(DatabaseOperations.getRandomWord("trial0"));
        
      //  System.out.println("\n\n"+DatabaseOperations.getWordsRetention("vaibhav"));
       // System.out.println("\n"+DatabaseOperations.showHistory("vaibhav"));
       
        
        //test retention
        /*
        ArrayList<String> list=new ArrayList<String>();
        list=DatabaseOperations.getWordsRetention("vaibhav");
        ArrayList<String> words_asked=new ArrayList<String>();
        
        int count=(list.size()/2 );
        System.out.println(count);
        int i;
        int c=0;
        
        int j=0;
        
        System.out.println(list.get(c));
        words_asked.add(list.get(c));
        System.out.println(list);
        
        words_asked.add("cat");
        words_asked.add("hat");
        
        while(j<2){
            System.out.println("words asked "+words_asked);
            c=c+2*(1+ (int)(Math.random()*3));
            while(words_asked.contains(list.get(c))){
                c++;
                c++;
                System.out.println("c is " +c);
            }
            System.out.println(list.get(c));
            System.out.println("ques is "+ ApiFetch.getMeaning("vaibhav", list.get(c), "q"));
           // System.out.println("answer is ")+;
            words_asked.add(list.get(c));
            j++;
        }
        
        System.out.println("at the end words asked are "+words_asked);
        
        
        */
        
        //end retention test
        
        
        
        /*
        while (words_asked.contains(list.get(c+2*(1+ (int)(Math.random()*4))))) {
            
        }
        */
     
   /*  
        System.out.println(DatabaseOperations.returnDate("trial0", "mango"));
        System.out.println(DatabaseOperations.returnCount("trial0", "apple"));
   */     
        
        /*
        ArrayList<String> list=new ArrayList<String>();
        list.add("trial0");
        list.add("radio");
        list.add("15");
        
        DatabaseOperations.updateHasSearched(list);
        */
       
        /*
        ArrayList<String> list=new ArrayList<String>();
        list.add("trial0");
        list.add("mango");
        list.add("15");
        
       DatabaseOperations.updateHasSearched(list);
        
        */
        /*
        ArrayList<String> list=new ArrayList<String>();
        list.add("trial0");
        list.add("tree");
        list.add("14");
        
        d.updateHasSearched(list);
        * */
        //System.out.println(d.createUser("trial1", "trial1", "trial1", "trial1", "trial1"));
        //System.out.println(d.recoverPassword("trial0"));
        
        
        //test showHistory
        /*
        System.out.println(DatabaseOperations.showHistory("trial0"));
        System.out.println(DatabaseOperations.showHistory("trial1"));
        */
        
        //test storequizdata
      //d.storeQuizData("trial0", 4, 7, 8);
        //d.storeQuizData("trial0", -1, 6, 4);
        
        
        //test scoreretention,depth,
        /*
        System.out.println(DatabaseOperations.getScoreRention("trial0"));
        System.out.println(DatabaseOperations.getScoreDepth("trial0"));
        System.out.println(DatabaseOperations.getScoreWidth("trial0"));
        System.out.println(DatabaseOperations.getScoreWidth("trial1"));
        
        */
        //test getAllwordssearched
        /*
        System.out.println(DatabaseOperations.getAllWordsSearched("trial0"));
        System.out.println(DatabaseOperations.getAllWordsSearched("trial1"));
        
        //test returnJoinDate
        System.out.println(DatabaseOperations.getJoinDate("trial0"));
        System.out.println(DatabaseOperations.getJoinDate("abcd"));
        
        
        System.out.println(DatabaseOperations.getRandomWordFromAll());
        * */
        
        
    }
}