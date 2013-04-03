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
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author snooze-wake
 */
public class BackGround implements NativeKeyListener {

   //private static final long serialVersionUID = 1865350670081087993L;

    public BackGround() {
        try {
           // System.out.println(GlobalScreen.isNativeHookRegistered());
            
           GlobalScreen.registerNativeHook();
            GlobalScreen.getInstance().addNativeKeyListener(this);
            
            
         //   GlobalScreen.getInstance().addNativeKeyListener(new GlobalKeyListenerExample());
            readFile();
            
            
       //     wait1();
            
            
            JPanel jp = new JPanel();
            jp.setVisible(true);
            System.out.println(" till here");
            
        } catch (NativeHookException  ex) {
            Logger.getLogger(BackGround.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }   
    }

 

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        
        
        if(nke.getKeyCode() == keyFpressed)
        {
            iskeyFpressed = true;
        }
       
                
      
        if (iskeyFpressed) {
            {
                tempkeyS = nke.getKeyCode();
                if(nke.getKeyCode() == keySpressed)
                {
                    
                System.out.println("Short cut pressed");
                try {
                    String data = (String) Toolkit.getDefaultToolkit()
                            .getSystemClipboard().getData(DataFlavor.stringFlavor);
                    System.out.println(" word for searching" + data);
                    ArrayList<String> tempget = ApiFetch.getMeaning(WordBuilder.getCurrentUser(), data, "s");
                    
                    if(tempget.size()>0)
                    {
                        System.out.println(tempget.get(0));
                        Notify.showNotification(tempget.get(0));
                       // System.out.println("Notificaiton called: After calling");
                    }
                    else
                    {
                        Notify.showNotification("");                            // Send Garbage
                    }
                   
                    
                } catch (UnsupportedFlavorException ex) {
                   
                } catch (IOException ex) {
                   
                }   catch (SQLException ex) {
                        Logger.getLogger(BackGround.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(BackGround.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }
        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
        if(nke.getKeyCode()== keyFpressed)
        {
            iskeyFpressed =false;
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        

    }
    
    public static void exitBG()
    {
         GlobalScreen.unregisterNativeHook();
                System.runFinalization();
                System.exit(0);
    }
     
    
    public static void readFile()
    {
         try {
             new File("hello").getAbsolutePath();
             File fopen =  new File("wordnet/data/short.txt");
             fopen.createNewFile();
             
            FileInputStream fstream = new FileInputStream(
                    fopen);
                    
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;

            for(int i=0; i<1;i++) {
                
                line = br.readLine();
                if (line == null) {
                    BackGround.setkeys(17,73);
                    BackGround.writeToFile(17,73);
                    break;
                } else {
                    System.out.println(line);
                    String [] a = line.split(":");
                    BackGround.setkeys(Integer.parseInt(a[0]),Integer.parseInt(a[1]));
                }

            }
            in.close();
            br.close();
            fstream.close();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            
        }
    }
    public static void writeToFile(int a, int b)
    {
        File file = new File("wordnet/data/short.txt");
		String content =a+":"+b ;
 
		try (FileOutputStream fop = new FileOutputStream(file)) {
 
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();
 
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
 
			
 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public static void setkeys(int keyF,int keyS)
    {
        keyFpressed=keyF;
        keySpressed=keyS;
    }
    
    public static String getCurrentKey()
    {
        readFile();
        String temp= NativeKeyEvent.getKeyText(keyFpressed)+" + "+NativeKeyEvent.getKeyText(keySpressed);
        return temp;
    }
    public static String listen()
    {
        tempkeyS=0;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BackGround.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(tempkeyS!=0)
       {
           writeToFile(17,tempkeyS);
       }
       
       return getCurrentKey();
       
    }
    static int keyFpressed ;
    static int keySpressed ;
    boolean iskeyFpressed = false;
    
 
    static int tempkeyS;
}
