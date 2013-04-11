/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import database.DatabaseOperations;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kantri
 */
public class Signin extends javax.swing.JFrame {

    WindowAdapter windowadapter;
    /**
     * Creates new form Signin
     */
    public Signin() {
        initComponents();
         this.setLocation(scrSize.width - (scrSize.width)/2 - (this.getWidth())/2 ,scrSize.height -(scrSize.height*1)/2 - (this.getHeight())/2  );
          windowadapter = new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                
                
                BackGround.exitBG();
                System.exit(0);
                //System.exit(0);
            }
        };
     
     
     addWindowListener(windowadapter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        forgot = new javax.swing.JButton();
        create = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SignIn");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Password");

        username.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        username.setToolTipText("min 2 chars max 15");

        password.setToolTipText("min 2 chars max 15");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        forgot.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        forgot.setText("Forgot Password");
        forgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotActionPerformed(evt);
            }
        });

        create.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        create.setText("Sign-Up");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        login.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        login.setText("Login");
        login.setIconTextGap(15);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel4.setText("Word Builder");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(forgot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(create)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(87, 87, 87))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create)
                    .addComponent(forgot))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void forgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotActionPerformed
        // TODO add your handling code here:
        WordBuilder.signin.setVisible(false);
        WordBuilder.forgotpassword.secques.setVisible(false);
        WordBuilder.forgotpassword.secans.setVisible(false);
        WordBuilder.forgotpassword.questionlabel.setVisible(false);
        WordBuilder.forgotpassword.answer.setVisible(false);
        WordBuilder.forgotpassword.check.setVisible(false);
        WordBuilder.forgotpassword.enter.setVisible(true);
        WordBuilder.forgotpassword.username.setVisible(true);
        WordBuilder.forgotpassword.username.setEditable(true);
        WordBuilder.forgotpassword.username.setText(null);
        WordBuilder.forgotpassword.answer.setText(null);
        WordBuilder.forgotpassword.setVisible(true);
        
    }//GEN-LAST:event_forgotActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        // TODO add your handling code here:
        WordBuilder.signin.setVisible(false);
       WordBuilder.signup.setVisible(true);
      
    }//GEN-LAST:event_createActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        boolean cond1=true;
        boolean cond2=true;
        boolean cond=false;
        ArrayList<String> list;

        String user=this.username.getText();
        String pass=this.password.getText();

        if(user.length()>=2 && user.length()<=15)
        {
            cond1=true;
        }else{
            cond1=false;
            JOptionPane.showMessageDialog(this, "Check Username Character Length", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(pass.length()>=2 && pass.length()<=15)
        {
            cond2=true;
        }else{
            cond2=false;
            JOptionPane.showMessageDialog(this, "Check Password Character Length", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(cond1 && cond2){
            try {
                if(DatabaseOperations.checkLogin(user, pass)){
                    cond=true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(cond){
            System.out.println("Lets go forward Login Successful");

           WordBuilder.signin.setVisible(false);
            WordBuilder.mainpage.setVisible(true);
            WordBuilder.setCurrentUser(this.username.getText());
            if(WordBuilder.bg==null)
            {
            WordBuilder.bg = new BackGround();    
            }
            if(WordBuilder.bi==null)
            {
                WordBuilder.bi= new BaseIcon();
            }
        
        }
        else{
            JOptionPane.showMessageDialog(this, "Invalid Login", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_loginActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
        login.doClick();
    }//GEN-LAST:event_passwordActionPerformed

private Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create;
    private javax.swing.JButton forgot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
