/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author snooze-wake
 */
public class DatabaseOperationsTest {
    
    public DatabaseOperationsTest() {
        try {
            DatabaseOperations.init();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseOperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of init method, of class DatabaseOperations.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        DatabaseOperations.init();
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class DatabaseOperations.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        String name = "trial0";
        String uid = "trial0";
        String pass = "trial0";
        String ques = "trial0";
        String answer = "trial0";
        boolean expResult = false;
        boolean result = DatabaseOperations.createUser(name, uid, pass, ques, answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkLogin method, of class DatabaseOperations.
     */
    @Test
    public void testCheckLogin() throws Exception {
        System.out.println("checkLogin");
        String uid = "trial0";
        String pswd = "trial0";
        boolean expResult = true;
        boolean result = DatabaseOperations.checkLogin(uid, pswd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of recoverPassword method, of class DatabaseOperations.
     */
    @Test
    public void testRecoverPassword() throws Exception {
        System.out.println("recoverPassword");
        String uid = "trial0";
        ArrayList expResult = new ArrayList<String>() {{
            add("trial0");
           add("trial0"); 
           add("trial0");
        }};
        ArrayList result = DatabaseOperations.recoverPassword(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of returnDate method, of class DatabaseOperations.
     */
    @Test
    public void testReturnDate() throws Exception {
        System.out.println("returnDate");
        String uid = "trial0";
        String word = "apple";
        ArrayList expResult = new ArrayList<String>() {{
            add("2013-03-26");
           add("2013-03-28"); 
        }};
        ArrayList result = DatabaseOperations.returnDate(uid, word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   


 

    /**
     * Test of returnCount method, of class DatabaseOperations.
     */
    @Test
    public void testReturnCount() throws Exception {
        System.out.println("returnCount");
        String uid = "trial0";
        String word = "apple";
        int expResult = 3;
        int result = DatabaseOperations.returnCount(uid, word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllWordsSearched method, of class DatabaseOperations.
     */
    @Test
    public void testGetAllWordsSearched() throws Exception {
        System.out.println("getAllWordsSearched");
        String uid = "12";
        ArrayList expResult =  new ArrayList<String>() {{
           
           add("frequency");
           add("2013-04-04"); 
           add("2013-04-04");
           add("2");
            add("god");
           add("2013-04-04"); 
           add("2013-04-04");
           add("2");
            
           add("good");
           add("2013-04-04"); 
           add("2013-04-04");
           add("6");
          
        }};
        ArrayList result = DatabaseOperations.getAllWordsSearched(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of getJoinDate method, of class DatabaseOperations.
     */
    @Test
    public void testGetJoinDate() throws Exception {
        System.out.println("getJoinDate");
        String uid = "trial0";
        String expResult = "2013-03-26";
        String result = DatabaseOperations.getJoinDate(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of showHistory method, of class DatabaseOperations.
     */
    @Test
    public void testShowHistory() throws Exception {
        System.out.println("showHistory");
        String uid = "12";
        ArrayList expResult = new ArrayList<String>() {{
            
           add("frequency"); 
           add("god");
           add("good");
        }};
        ArrayList result = DatabaseOperations.showHistory(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of getScoreRention method, of class DatabaseOperations.
     */
    @Test
    public void testGetScoreRention() throws Exception {
        System.out.println("getScoreRention");
        String uid = "trial0";
        ArrayList expResult = new ArrayList() {{
           add(1.0); 
           add(4.0);
           add(4.0);
        }};
        ArrayList result = DatabaseOperations.getScoreRention(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getScoreDepth method, of class DatabaseOperations.
     */
    @Test
    public void testGetScoreDepth() throws Exception {
        System.out.println("getScoreDepth");
        String uid = "trial0";
        ArrayList expResult = new ArrayList() {{
           add(2.0); 
           add(6.0);
           add(12.0);
        }};
        ArrayList result = DatabaseOperations.getScoreDepth(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getScoreWidth method, of class DatabaseOperations.
     */
    @Test
    public void testGetScoreWidth() throws Exception {
        System.out.println("getScoreWidth");
        String uid = "trial0";
        ArrayList expResult = new ArrayList() {{
           add(2.0); 
           add(6.5);
           add(13.0);
        }};
        ArrayList result = DatabaseOperations.getScoreWidth(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getLastQuizData method, of class DatabaseOperations.
     */
    @Test
    public void testGetLastQuizData() throws Exception {
        System.out.println("getLastQuizData");
        String uid = "trial0";
        ArrayList expResult = new ArrayList() {{
            
           add(0); 
           add(6);
           add(4);
        }};
        ArrayList result = DatabaseOperations.getLastQuizData(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

   
}