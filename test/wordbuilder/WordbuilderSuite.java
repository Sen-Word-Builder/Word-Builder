/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author snooze-wake
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ wordbuilder.WordBuilderTest.class,  wordbuilder.ApiFetchTest.class})
public class WordbuilderSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}