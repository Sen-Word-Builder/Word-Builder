/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mohit
 */
public class DatabaseOperationsTest {
    public static void main(String args []) throws SQLException, ClassNotFoundException{
     //DatabaseOperations d = new DatabaseOperations();
       // System.out.println(d.createUser("trial0", "trial0", "trial0", "trial0", "trial0"));
        
        DatabaseOperations.init();
       System.out.println(DatabaseOperations.checkLogin("trial0", "trial0"));
        System.out.println(DatabaseOperations.getRandomWord("trial0"));
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
        System.out.println(DatabaseOperations.getScoreRention("trial0"));
        System.out.println(DatabaseOperations.getScoreDepth("trial0"));
        System.out.println(DatabaseOperations.getScoreWidth("trial0"));
        System.out.println(DatabaseOperations.getScoreWidth("trial1"));
        
        
        //test getAllwordssearched
        System.out.println(DatabaseOperations.getAllWordsSearched("trial0"));
        System.out.println(DatabaseOperations.getAllWordsSearched("trial1"));
        
        //test returnJoinDate
        System.out.println(DatabaseOperations.getJoinDate("trial0"));
        System.out.println(DatabaseOperations.getJoinDate("abcd"));
        
        
        System.out.println(DatabaseOperations.getRandomWordFromAll());
        
        System.out.println(DatabaseOperations.getLastQuizData("trial0"));
    }
}