/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author www.ThePCWizard.in
 */
public class Splash {
public static SplashScreen loadingScreen;
public static Double loadingTextArea;
public static Double loadingProgressArea;
public static Graphics2D loadingGraphics;
public static Font myfont;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here   
        
        loadingMethod();
        
        
        if (loadingScreen != null) {
            loadingScreen.close();
        }
         
    }
    
    public static void loadingMethod() {
        loadingScreen = SplashScreen.getSplashScreen();
        if (loadingScreen !=null){
            try {
                Thread.sleep(5000);
                // if there are any problems displaying the splash this will be null
            } catch (InterruptedException ex) {
                Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        }
    }
          
}
