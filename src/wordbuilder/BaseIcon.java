/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author snooze-wake
 */
public class BaseIcon {
 
    public static void set() {
        /* Use an appropriate Look and Feel */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //Schedule a job for the event-dispatching thread:
        //adding TrayIcon.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
     
    private static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(createImage("images/wordbuilderlogo.gif", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();
        
         
        // Create a popup menu components
        MenuItem aboutItem = new MenuItem("About");
        CheckboxMenuItem cb1 = new CheckboxMenuItem("Notify");
       // CheckboxMenuItem cb2 = new CheckboxMenuItem("Set tooltip");
        MenuItem takeQuiz = new MenuItem("Take Quiz");
        MenuItem showAnalysis = new MenuItem("Show Analysis");
      /*  MenuItem errorItem = new MenuItem("Error");
        MenuItem warningItem = new MenuItem("Warning");
        MenuItem infoItem = new MenuItem("Info");
        MenuItem noneItem = new MenuItem("None");*/
        MenuItem exitItem = new MenuItem("Exit");
         
        //Add components to popup menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(cb1);
     //   popup.add(cb2);
        popup.addSeparator();
        popup.add(takeQuiz);
        popup.addSeparator();
        popup.add(showAnalysis);
     /*   displayMenu.add(errorItem);
        displayMenu.add(warningItem);
        displayMenu.add(infoItem);
        displayMenu.add(noneItem);*/
        popup.add(exitItem);
         
        trayIcon.setPopupMenu(popup);
        trayIcon.setImageAutoSize(true);
         
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
         
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "This dialog box is run from System Tray");
                
            }
        });
         
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "This dialog box is run from the About menu item");
            }
        });
         
        cb1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int cb1Id = e.getStateChange();
                if (cb1Id == ItemEvent.SELECTED){
                    
                } else {
                    trayIcon.setImageAutoSize(false);
                    
                }
            }
        });
         
       
   /*     cb2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int cb2Id = e.getStateChange();
                if (cb2Id == ItemEvent.SELECTED){
                    trayIcon.setToolTip("Sun TrayIcon");
                } else {
                    trayIcon.setToolTip(null);
                }
            }
        });
         */
     
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }
     
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = BaseIcon.class.getClassLoader().getResource(path);
        
        System.out.println(imageURL);
         
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}
