/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.SQLException;

/**
 *
 * @author Mohit
 */
public class DatabaseOperationsTest {
    public static void main(String args []) throws SQLException, ClassNotFoundException{
     DatabaseOperations d = new DatabaseOperations();
        System.out.println(d.createUser("trial0", "trial0", "trial0", "trial0", "trial0"));
        System.out.println(d.checkLogin("trial0", "trial0"));
     
     /*
        System.out.println(d.returnDate("trial0", "abc"));
        System.out.println(d.returnCount("trial0", "abc"));
        * */
    }
}