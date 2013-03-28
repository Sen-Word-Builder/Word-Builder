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
     DatabaseOperations d = new DatabaseOperations();
    //    System.out.println(d.createUser("trial0", "trial0", "trial0", "trial0", "trial0"));
        System.out.println(d.checkLogin("trial0", "trial0"));
        System.out.println(d.getRandomWord("trial0"));
     /*
        System.out.println(d.returnDate("trial0", "abc"));
        System.out.println(d.returnCount("trial0", "abc"));
        * */
        /*
        ArrayList<String> list=new ArrayList<String>();
        list.add("trial0");
        list.add("mango");
        list.add("15");
        
        d.updateHasSearched(list);
        * */
       
        /*
        ArrayList<String> list=new ArrayList<String>();
        list.add("trial0");
        list.add("guava");
        list.add("3");
        
        d.updateHasSearched(list);
        * */
        
        /*
        ArrayList<String> list=new ArrayList<String>();
        list.add("trial0");
        list.add("tree");
        list.add("14");
        
        d.updateHasSearched(list);
        * */
        //System.out.println(d.createUser("trial1", "trial1", "trial1", "trial1", "trial1"));
        System.out.println(d.recoverPassword("trial0"));
        
        
        //test showHistory
        System.out.println(d.showHistory("trial0"));
        System.out.println(d.showHistory("trial1"));
    }
}