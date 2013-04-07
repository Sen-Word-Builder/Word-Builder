/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author snooze-wake
 */
public class ApiFetchTest {
    
   
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("wordnet.database.dir","wordnet/dict");
        ApiFetch.initInstance();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }



    /**
     * Test of getHypernym method, of class ApiFetch.
     */
    @Test
    @SuppressWarnings("empty-statement")
    public void testGetHypernym() {
        System.out.println("getHypernym");
        String input = "kill";
        ArrayList expResult = new ArrayList<String>() {{
            add("termination");
            add("ending");
            add("conclusion");
            add("change of state");
            add("change");
        }};
       
        ArrayList result = ApiFetch.getHypernym(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getMeaning method, of class ApiFetch.
     */
    @Test
    public void testGetMeaning() throws Exception {
        System.out.println("getMeaning");
        String uid = null;
        String word = "kill";
        String why = "q";
        ArrayList expResult = new ArrayList<String>() {{
            add("cause to die; put to death, usually intentionally or knowingly");
           add("kill"); 
        }};
        ArrayList result = ApiFetch.getMeaning(uid, word, why);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxFrequency method, of class ApiFetch.
     */
    @Test
    public void testGetMaxFrequency() {
        System.out.println("getMaxFrequency");
        String inputword = "good";
        int expResult = 4;
        int result = ApiFetch.getMaxFrequency(inputword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getHyponym method, of class ApiFetch.
     */
    @Test
    public void testGetHyponym() {
        System.out.println("getHyponym");
        String input = "kill";
        ArrayList expResult =  new ArrayList<String>() {{
            add("deathblow");
           add("coup de grace"); 
        }};
        ArrayList result = ApiFetch.getHyponym(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}