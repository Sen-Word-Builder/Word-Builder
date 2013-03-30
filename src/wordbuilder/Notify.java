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
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
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
import javax.swing.WindowConstants;

/**
 *
 * @author snooze-wake
 */
public class Notify extends JFrame {

    public static void showNotification(String input) {

        if (!iscalled) {
            iscalled = true;


            message = " ";
            header=" ";
            frame = new JFrame();
            frame.setSize(300, 125);
            frame.setUndecorated(true);
            frame.setLayout(new GridBagLayout());
            // frame.setBackground(Color.yellow);

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.weightx = 1.0f;
            constraints.weighty = 1.0f;
            constraints.insets = new Insets(5, 5, 5, 5);
            constraints.fill = GridBagConstraints.BOTH;
            headingLabel = new JLabel(header);

            //        headingLabel .setIcon(headingIcon); // --- use image icon you want to be as heading image.
            headingLabel.setOpaque(false);
            frame.add(headingLabel, constraints);
            constraints.gridx++;
            constraints.weightx = 0f;
            constraints.weighty = 0f;
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.NORTH;
            JButton cloesButton = new JButton(new AbstractAction("x") {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    frame.dispose();
                }
            });
            frame.add(cloesButton, constraints);
            constraints.gridx = 0;
            constraints.gridy++;
            constraints.weightx = 1.0f;
            constraints.weighty = 1.0f;
            constraints.insets = new Insets(5, 5, 5, 5);
            constraints.fill = GridBagConstraints.BOTH;
            messageLabel = new JLabel("<HtMl>"+message);
            frame.add(messageLabel, constraints);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
            Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar
            frame.setLocation(scrSize.width - frame.getWidth() - frame.getWidth() / 2, scrSize.height - toolHeight.bottom - frame.getHeight() - frame.getHeight() / 2);
            Notify.showVis(input);
             
            }
          else
        {
            showVis(input);
        }
       
        }
    
    public static void showVis(String input) {
        try {
            
            
             header = "Hi " + WordBuilder.getCurrentUser();
            ArrayList<String> data = ApiFetch.getMeaning(WordBuilder.getCurrentUser(), input, "s");
            if (data.size() > 0) {
                message = data.get(0);
            } else {
                message = "No Such Word Found";
            }
            headingLabel.setText(header);
            messageLabel.setText("<HTML>"+ message);
             frame.setVisible(true);
              new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000); // time after which pop up will be disappeared.
                        frame.dispose();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
               
            ;
        }
    

    .start();
           
          
            
        } catch (SQLException ex) {
            Logger.getLogger(Notify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Notify.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //private JButton closebutton;
    static String message;
    static String header;
    static JFrame frame;
    static boolean iscalled = false;
    private static JLabel messageLabel = new JLabel("<HtMl>" + message);
    private static JLabel headingLabel;
    private static Timer t1;
}
