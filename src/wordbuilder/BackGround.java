/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeSystem;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author snooze-wake
 */
public class BackGround implements NativeKeyListener {

    private static final long serialVersionUID = 1865350670081087993L;

    public BackGround() {
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.getInstance().addNativeKeyListener(this);
            readFile();

            wait1();
        } catch (NativeHookException ex) {
            Logger.getLogger(BackGround.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public void wait1() {
        int count = 0;
        
        while(true)
        {
            
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        System.out.println(nke.getKeyCode() + " pressed ");
        if (nke.getKeyCode() == keyFpressed) {
            {
                
                if(nke.getKeyCode() == keySpressed)
                {
                    
                
                try {
                    String data = (String) Toolkit.getDefaultToolkit()
                            .getSystemClipboard().getData(DataFlavor.stringFlavor);
                    System.out.println(data);
                } catch (UnsupportedFlavorException ex) {
                   
                } catch (IOException ex) {
                   
                }
                }
            }
        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        System.out.println(nke.getKeyCode() + " Typed");

    }
     
    
    public static void readFile()
    {
         try {
             
            FileInputStream fstream = new FileInputStream(
                    "wordnet/data/short.txt");
                    
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;

            while (true) {
                
                line = br.readLine();
                if (line == null) {
                    BackGround.setkeys(17,73);
                    break;
                } else {
                    System.out.println(line);
                }

            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public static void setkeys(int keyF,int keyS)
    {
        keyFpressed=keyF;
        keySpressed=keyS;
    }
    static int keyFpressed ;
    static int keySpressed ;
}
