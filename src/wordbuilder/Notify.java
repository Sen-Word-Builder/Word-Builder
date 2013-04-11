/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author snooze-wake
 */
public class Notify extends JFrame {

    public static void showNotification(String input) throws ClassNotFoundException {

        if (!iscalled && Notify.getNotify()) {
          
            
            iscalled = true;
            message = " ";
            header = " ";
            frame = new JFrame();
            frame.setSize(300, 120);
            frame.setUndecorated(true);
            frame.setLayout(new GridBagLayout());
            // frame.setBackground(Color.yellow);
            Dimension arcSize = new Dimension(50, 50);
            frame.setShape(new RoundRectangle2D.Double
            (0d, 0d, frame.getWidth(), frame.getHeight(), arcSize.width, arcSize.height));
            
            
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.weightx = 1.0f;
            constraints.weighty = 1.0f;
           // constraints.insets = new Insets(5, 5, 5, 5);
            constraints.fill = GridBagConstraints.BOTH;
            headingLabel = new JLabel(header);

            //        headingLabel .setIcon(headingIcon); // --- use image icon you want to be as heading image.
            headingLabel.setOpaque(true);
            frame.add(headingLabel, constraints);
          /*  constraints.gridx++;
            constraints.weightx = 0f;
            constraints.weighty = 0f;
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.NORTH; */
            /*     JButton cloesButton = new JButton(new AbstractAction("x") {
             @Override
             public void actionPerformed(final ActionEvent e) {
             frame.dispose();
             }
             });
             * */
            //  frame.add(cloesButton, constraints);
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.weightx = 1.0f;
            constraints.weighty = 1.0f;
           // constraints.insets = new Insets(5, 5, 5, 5);
            constraints.fill = GridBagConstraints.BOTH; 
            messageLabel = new JLabel("<HtMl>" + message);
            messageLabel.setOpaque(true);
            messageLabel.setBackground(Color.getHSBColor(0, 0, 1.05f));
            headingLabel.setBackground(Color.getHSBColor(0, 0, 1.05f));
            frame.add(messageLabel, constraints);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
            Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar
            frame.setLocation(scrSize.width - frame.getWidth() - frame.getWidth() / 2, scrSize.height - toolHeight.bottom - frame.getHeight() - frame.getHeight() / 2);
            frame.setAlwaysOnTop(true);
            //  System.out.println("creation");

            showVis(input);

        } else {
            showVis(input);
        }

    }

    private static void showVis(String input) {


        if (Notify.getNotify()) {
              //System.out.println("I am here");

            header ="<html><B>"+"   Hi </B> <I>"  + WordBuilder.getCurrentUser()+ "</I> </html>" ;
          //  System.out.println(header);
            System.out.println(Thread.activeCount());
            String empty = "  " ;
            headingLabel.setForeground(Color.WHITE);
            headingLabel.setText(header);
            if (!input.equals("")) {
                message = input;
                
                messageLabel.setForeground(Color.WHITE);
                messageLabel.setText("<HTML>" + message);
                
            } else {
                
                message = "No Such Word Found";
                messageLabel.setForeground(Color.WHITE);
                messageLabel.setText("<HTML>" + message);
                
            }
          //  headingLabel.setText(header);
            
            
            

            if (frame.isVisible() == false) {
                frame.setVisible(true);
            }


            if (frame.isVisible() && !threadisRunning) {

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            //   System.out.println("Thread Executed");
                            threadisRunning = true;
                            Thread.sleep(5000);                                     // time after which pop up will be disappeared.
                            frame.setVisible(false);
                            threadisRunning = false;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                ;
            }

        
    

    .start(); 
            }

            //  System.out.println( Thread.activeCount());





            }
        

    }
  
    
    public static void unSetNotify() {
        isNotify = false;
    }

    public static void setNotify() {
        isNotify = true;
    }

    public static boolean getNotify() {
        return isNotify;
    }
    //private JButton closebutton;
    static String message;
    static String header;
    static JFrame frame;
    static boolean iscalled = false;
    private static JLabel messageLabel ;
    private static JLabel headingLabel;
    private static Timer t1;
    private static boolean isNotify = true;
    private static boolean threadisRunning = false;
    private static Thread a;
}
