/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
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
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class DatabaseOperations.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        String name = "";
        String uid = "";
        String pass = "";
        String ques = "";
        String answer = "";
        boolean expResult = false;
        boolean result = DatabaseOperations.createUser(name, uid, pass, ques, answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLogin method, of class DatabaseOperations.
     */
    @Test
    public void testCheckLogin() throws Exception {
        System.out.println("checkLogin");
        String uid = "";
        String pswd = "";
        boolean expResult = false;
        boolean result = DatabaseOperations.checkLogin(uid, pswd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recoverPassword method, of class DatabaseOperations.
     */
    @Test
    public void testRecoverPassword() throws Exception {
        System.out.println("recoverPassword");
        String uid = "";
        ArrayList expResult = null;
        ArrayList result = DatabaseOperations.recoverPassword(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnDate method, of class DatabaseOperations.
     */
    @Test
    public void testReturnDate() throws Exception {
        System.out.println("returnDate");
        String uid = "";
        String word = "";
        ArrayList expResult = null;
        ArrayList result = DatabaseOperations.returnDate(uid, word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomWord method, of class DatabaseOperations.
     */
    @Test
    public void testGetRandomWord() throws Exception {
        System.out.println("getRandomWord");
        String uid = "";
        String expResult = "";
        String result = DatabaseOperations.getRandomWord(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomWordFromAll method, of class DatabaseOperations.
     */
    @Test
    public void testGetRandomWordFromAll() throws Exception {
        System.out.println("getRandomWordFromAll");
        String expResult = "";
        String result = DatabaseOperations.getRandomWordFromAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateHasSearched method, of class DatabaseOperations.
     */
    @Test
    public void testUpdateHasSearched() throws Exception {
        System.out.println("updateHasSearched");
        ArrayList<String> list = null;
        DatabaseOperations.updateHasSearched(list);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnCount method, of class DatabaseOperations.
     */
    @Test
    public void testReturnCount() throws Exception {
        System.out.println("returnCount");
        String uid = "";
        String word = "";
        int expResult = 0;
        int result = DatabaseOperations.returnCount(uid, word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllWordsSearched method, of class DatabaseOperations.
     */
    @Test
    public void testGetAllWordsSearched() throws Exception {
        System.out.println("getAllWordsSearched");
        String uid = "";
        ArrayList expResult = null;
        ArrayList result = DatabaseOperations.getAllWordsSearched(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJoinDate method, of class DatabaseOperations.
     */
    @Test
    public void testGetJoinDate() throws Exception {
        System.out.println("getJoinDate");
        String uid = "";
        String expResult = "";
        String result = DatabaseOperations.getJoinDate(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showHistory method, of class DatabaseOperations.
     */
    @Test
    public void testShowHistory() throws Exception {
        System.out.println("showHistory");
        String uid = "";
        ArrayList expResult = null;
        ArrayList result = DatabaseOperations.showHistory(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeQuizData method, of class DatabaseOperations.
     */
    @Test
    public void testStoreQuizData() throws Exception {
        System.out.println("storeQuizData");
        String uid = "";
        int score_ret = 0;
        int score_wid = 0;
        int score_dep = 0;
        DatabaseOperations.storeQuizData(uid, score_ret, score_wid, score_dep);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScoreRention method, of class DatabaseOperations.
     */
    @Test
    public void testGetScoreRention() throws Exception {
        System.out.println("getScoreRention");
        String uid = "";
        ArrayList expResult = null;
        ArrayList result = DatabaseOperations.getScoreRention(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScoreDepth method, of class DatabaseOperations.
     */
    @Test
    public void testGetScoreDepth() throws Exception {
        System.out.println("getScoreDepth");
        String uid = "";
        ArrayList expResult = null;
        ArrayList result = DatabaseOperations.getScoreDepth(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScoreWidth method, of class DatabaseOperations.
     */
    @Test
    public void testGetScoreWidth() throws Exception {
        System.out.println("getScoreWidth");
        String uid = "";
        ArrayList expResult = null;
        ArrayList result = DatabaseOperations.getScoreWidth(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastQuizData method, of class DatabaseOperations.
     */
    @Test
    public void testGetLastQuizData() throws Exception {
        System.out.println("getLastQuizData");
        String uid = "";
        ArrayList expResult = null;
        ArrayList result = DatabaseOperations.getLastQuizData(uid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DatabaseOperations.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        DatabaseOperations.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}