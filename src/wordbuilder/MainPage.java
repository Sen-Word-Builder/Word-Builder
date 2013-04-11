/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;

import database.DatabaseOperations;
import edu.smu.tspell.wordnet.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author chandra
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    WindowAdapter windowadapter;
    public MainPage() {
        initComponents();
        
      //  this.setUndecorated(true);
        unsetEdit();
      
        this.setLocation(scrSize.width - (scrSize.width)/2 - (this.getWidth())/2 ,scrSize.height -(scrSize.height*1)/2 - (this.getHeight())/2  );
     windowadapter = new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                //System.out.println("hello world");
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

        jToggleButton3 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jToggleButton3.setText("jToggleButton3");

        setTitle("WordBuilder");
        setBackground(new java.awt.Color(138, 65, 101));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Query");

        jTextField1.setToolTipText("");
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Relatives");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Option");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Quiz");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setText("Analysis");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        jTabbedPane1.addTab("Antonyms", jScrollPane4);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jTabbedPane1.addTab("Synonyms", jScrollPane3);

        jButton6.setText("Hide");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("Logout");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("History");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Help");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setPreferredSize(new java.awt.Dimension(53, 23));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/options.gif"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setPreferredSize(new java.awt.Dimension(67, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quiz.gif"))); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(67, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analysis.gif"))); // NOI18N
        jLabel6.setToolTipText("");
        jLabel6.setPreferredSize(new java.awt.Dimension(67, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hide.gif"))); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(67, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.gif"))); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(67, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.gif"))); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(67, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jSeparator1)
            .addComponent(jTabbedPane1)
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(jButton5)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String toSearch = jTextField1.getText();
        setEdit();
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setText("");
        jTextArea2.setText("");
        jTextArea3.setText("");
        


        if (!(toSearch.equals("") | toSearch.equals(" "))) {
            try {
                renderText(toSearch);
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        jButton1.doClick();
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Options opst = new Options();
             opst = new Options();
             
        
        opst.setVisible(true);
            }
        });
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        WordBuilder.setCurrentUser(null);
        
      //  WordBuilder.getMainpage().dispose();
        BackGround.exitBG();
        
        System.exit(0);
       
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        WordBuilder.mainpage.jLabel3.setText("<html>Hello : <font color='blue'>" + WordBuilder.getCurrentUser() +"</font></html>");
        
        

    }//GEN-LAST:event_formWindowActivated

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        QuizAnalysis demo = new QuizAnalysis("Quiz Analysis");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        new History().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File("wordnet/data/help.pdf");
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     *
     * @param inputword Word whose Meanings are rendered on GUI
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private void renderText(String inputword) throws SQLException, ClassNotFoundException {
        try {
            setEdit();
            WordNetDatabase database = WordNetDatabase.getFileInstance();
            Synset[] synset = database.getSynsets(inputword,null,false);
            
            
            Synset[] synsetNoun = database.getSynsets(inputword, SynsetType.NOUN,false);
            
            Synset[] synsetAdj = database.getSynsets(inputword, SynsetType.ADJECTIVE,false);
            
            Synset[] synsetAdjsat = database.getSynsets(inputword, SynsetType.ADJECTIVE_SATELLITE,false);
            
            Synset[] synsetAdv = database.getSynsets(inputword, SynsetType.ADVERB,false);
            
            Synset[] synsetVerb = database.getSynsets(inputword, SynsetType.VERB,false);
            
            boolean isValidword = false;
            int y = 0;
            ArrayList<String> testcompare = new ArrayList();
            ArrayList<String> anticompare = new ArrayList();
            String actualW=inputword;
            if (synsetNoun.length > 0) {
                isValidword = true;
                jTextArea1.append("  " + inputword + " ~ NOUN \n \n");
                for (int i = 0; i < synsetNoun.length; i++) {
                    y = i + 1;
                    jTextArea1.append(" " + y + ". " + synsetNoun[i].getDefinition() + "\n \n");
                    String[] wordForms = synsetNoun[i].getWordForms();

                    for (int j = 0; j < wordForms.length; j++) {
                           
                        if(wordForms[j].equalsIgnoreCase(inputword))
                          {
                            actualW=wordForms[j];
                    
                          }
                        if (!wordForms[j].equals(inputword)) {
                            if (!testcompare.contains(wordForms[j])) {
                                jTextArea2.append(wordForms[j] + "\n \n");
                                testcompare.add(wordForms[j]);
                            }
                        }
                    }


                    WordSense[] antiwordForms = synsetNoun[i].getAntonyms(inputword);
                    for (int k = 0; k < antiwordForms.length; k++) {
                        
                        if (!anticompare.contains(antiwordForms[k].getWordForm())) {
                            jTextArea3.append(antiwordForms[k].getWordForm() + " \n \n");
                            anticompare.add(antiwordForms[k].getWordForm());

                        }



                    }
                }
            }
            if (synsetAdj.length > 0) {
                isValidword = true;
                jTextArea1.append("  " + inputword + " ~ ADJECTIVE \n \n");
                for (int i = 0; i < synsetAdj.length; i++) {
                    y = i + 1;

                    jTextArea1.append(" " + y + ". " + synsetAdj[i].getDefinition() + "\n \n");
                    String[] wordForms = synsetAdj[i].getWordForms();
                    for (int j = 0; j < wordForms.length; j++) {
                        if (!wordForms[j].equals(inputword)) {
                            if (!testcompare.contains(wordForms[j])) {
                                jTextArea2.append(wordForms[j] + "\n \n");
                                testcompare.add(wordForms[j]);
                            }
                        }
                        if(wordForms[j].equalsIgnoreCase(inputword))
                          {
                            actualW=wordForms[j];
                    
                          }

                    }

                    WordSense[] antiwordForms = synsetAdj[i].getAntonyms(inputword);
                    for (int k = 0; k < antiwordForms.length; k++) {
                        if (!anticompare.contains(antiwordForms[k].getWordForm())) {
                            jTextArea3.append(antiwordForms[k].getWordForm() + " \n \n");
                            anticompare.add(antiwordForms[k].getWordForm());

                        }
                    }


                }
                  if (synsetAdjsat.length > 0) {
                    for (int i = 0; i < synsetAdjsat.length; i++) {
                        y++;
                        jTextArea1.append(" " + y + ". " + synsetAdjsat[i].getDefinition() + "\n \n");
                        String[] wordForms = synsetAdjsat[i].getWordForms();
                        for (int j = 0; j < wordForms.length; j++) {
                            if (!wordForms[j].equals(inputword)) {
                                if (!testcompare.contains(wordForms[j])) {
                                    jTextArea2.append(wordForms[j] + "\n \n");
                                    testcompare.add(wordForms[j]);
                                }
                            }
                            if(wordForms[j].equalsIgnoreCase(inputword))
                          {
                            actualW=wordForms[j];
                    
                          }
                        }

                        WordSense[] antiwordForms = synsetAdjsat[i].getAntonyms(inputword);
                        for (int k = 0; k < antiwordForms.length; k++) {
                            if (!anticompare.contains(antiwordForms[k].getWordForm())) {
                                jTextArea3.append(antiwordForms[k].getWordForm() + " \n \n");
                                anticompare.add(antiwordForms[k].getWordForm());

                            }
                        }



                    }
                }

           
            }
            else
            {
                
            
                 if (synsetAdjsat.length > 0) {
                      isValidword = true;
                jTextArea1.append("  " + inputword + " ~ ADJECTIVE \n \n");
                    for (int i = 0; i < synsetAdjsat.length; i++) {
                        y=i+1;
                        jTextArea1.append(" " + y + ". " + synsetAdjsat[i].getDefinition() + "\n \n");
                        String[] wordForms = synsetAdjsat[i].getWordForms();
                        for (int j = 0; j < wordForms.length; j++) {
                            if (!wordForms[j].equals(inputword)) {
                                if (!testcompare.contains(wordForms[j])) {
                                    jTextArea2.append(wordForms[j] + "\n \n");
                                    testcompare.add(wordForms[j]);
                                }
                            }
                            if(wordForms[j].equalsIgnoreCase(inputword))
                          {
                            actualW=wordForms[j];
                    
                          }
                        }

                        WordSense[] antiwordForms = synsetAdjsat[i].getAntonyms(inputword);
                        for (int k = 0; k < antiwordForms.length; k++) {
                            if (!anticompare.contains(antiwordForms[k].getWordForm())) {
                                jTextArea3.append(antiwordForms[k].getWordForm() + " \n \n");
                                anticompare.add(antiwordForms[k].getWordForm());

                            }
                        }



                    }
                }
            }
            
            
            if (synsetVerb.length > 0) {
                isValidword = true;
                jTextArea1.append("  " + inputword + " ~ VERB \n \n");
                for (int i = 0; i < synsetVerb.length; i++) {
                    y = i + 1;
                    jTextArea1.append(" " + y + ". " + synsetVerb[i].getDefinition() + "\n \n");
                    String[] wordForms = synsetVerb[i].getWordForms();
                    for (int j = 0; j < wordForms.length; j++) {
                        if (!wordForms[j].equals(inputword)) {
                            if (!testcompare.contains(wordForms[j])) {
                                jTextArea2.append(wordForms[j] + "\n \n");
                                testcompare.add(wordForms[j]);
                            }
                        }
                        if(wordForms[j].equalsIgnoreCase(inputword))
                          {
                            actualW=wordForms[j];
                    
                          }

                    }

                    WordSense[] antiwordForms = synsetVerb[i].getAntonyms(inputword);
                    for (int k = 0; k < antiwordForms.length; k++) {
                        if (!anticompare.contains(antiwordForms[k].getWordForm())) {
                            jTextArea3.append(antiwordForms[k].getWordForm() + " \n \n");
                            anticompare.add(antiwordForms[k].getWordForm());

                        }
                    }


                }

            }
            if (synsetAdv.length > 0) {
                isValidword = true;
                jTextArea1.append("  " + inputword + " ~ ADVERB \n \n");
                for (int i = 0; i < synsetAdv.length; i++) {
                    y = i + 1;
                    jTextArea1.append(" " + y + ". " + synsetAdv[i].getDefinition() + "\n \n");
                    String[] wordForms = synsetAdv[i].getWordForms();
                    for (int j = 0; j < wordForms.length; j++) {
                        if (!wordForms[j].equals(inputword)) {
                            if (!testcompare.contains(wordForms[j])) {
                                jTextArea2.append(wordForms[j] + "\n \n");
                                testcompare.add(wordForms[j]);
                            }
                        }
                        if(wordForms[j].equalsIgnoreCase(inputword))
                          {
                            actualW=wordForms[j];
                    
                          }

                    }

                    WordSense[] antiwordForms = synsetAdv[i].getAntonyms(inputword);
                    for (int k = 0; k < antiwordForms.length; k++) {
                        if (!anticompare.contains(antiwordForms[k].getWordForm())) {
                            jTextArea3.append(antiwordForms[k].getWordForm() + " \n \n");
                            anticompare.add(antiwordForms[k].getWordForm());

                        }
                    }


                }
            }

            if (isValidword) {

                if (WordBuilder.getCurrentUser() != null) {
                    ArrayList<String> alsenddata = new ArrayList();
                    alsenddata.add(WordBuilder.getCurrentUser());
                    alsenddata.add(actualW);
                    alsenddata.add(String.valueOf(synset[ApiFetch.getMaxFrequency(inputword)].getTagCount(inputword)));
                    DatabaseOperations.updateHasSearched(alsenddata);
                }
            } else {
                jTextArea1.setText(" Sorry, queried input does not match the database");
            }

          unsetEdit();
          jTextArea1.setCaretPosition(0);
          jTextArea2.setCaretPosition(0);
          
        } catch (Exception ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Make all TextArea Editable
     */
    public void setEdit()
    {
        jTextArea1.setEditable(true);
        jTextArea1.setEditable(true);
        jTextArea1.setEditable(true);
    }
    
    /**
     * Make all Textarea uneditable
     */
    public void unsetEdit()
    {
        jTextArea1.setEditable(false);
        jTextArea2.setEditable(false);
        jTextArea3.setEditable(false);
        
    }
   
    /*public void windowClosing(WindowEvent e)
    {
        System.out.println(" Hello world");
        BackGround.exitBG();
    }
    */

 
    private Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton3;
    // End of variables declaration//GEN-END:variables
}
