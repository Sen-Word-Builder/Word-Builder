/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author snooze-wake
 */
public class WordBuilderTest {
    
    public WordBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        WordBuilder.setCurrentUser("hello");
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of getCurrentUser method, of class WordBuilder.
     * Current user tested when no one is logged in.
     */
    @Test
    public void testGetCurrentUser() {
        System.out.println("getCurrentUser");
        String expResult = "hello";
        
        String result = WordBuilder.getCurrentUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentUser method, of class WordBuilder.
     */
    @Test
    public void testSetCurrentUser() {
        System.out.println("setCurrentUser");
        String user = "hello";
        WordBuilder.setCurrentUser(user);
        String result =WordBuilder.getCurrentUser();
        assertEquals(user,result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}