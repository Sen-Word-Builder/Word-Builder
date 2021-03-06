/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_retention;

import database.DatabaseOperations;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Soundbank;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import wordbuilder.ApiFetch;
import wordbuilder.BackGround;
import wordbuilder.WordBuilder;

/**
 *
 * @author Mohit
 */
public class QuizRD extends javax.swing.JFrame {

    public  int max_size = 0;
    public  int counter_depth = 0;
    public  int size_depth;
    public  int no_of_questions = 10;
    public  int disp_depth;
    public  int disp_retention;
    public  int disp_width;
    public  ArrayList<String> words_asked = new ArrayList<String>();
    public  int score_retention;
    public  int score_depth;
    public  int score_width;
    public  String current_quiz;
    public  int quiz_score = 0;
    public  String ques_meaning;
    public  boolean last_answer = false;
    public  int c = 0;
    public  int c1 = 0;
    public  int j_retention = 0;
    public  int j_width = 0;
    public  int j_depth = 0;
    public  String hintanswer;
    public  String current_word, current_answer;
    public  ArrayList<String> words_retention_list = new ArrayList<String>();
    public  ArrayList<String> words_width_list = new ArrayList<String>();
    public  ArrayList<String> questions_asked = new ArrayList<String>();
    public  ArrayList<String> answered = new ArrayList<String>();
    public  ArrayList<String> answers = new ArrayList<String>();

    
    
    public  Timer time;
    
    public  int time_remaining=900;

    private void finishQuiz() throws SQLException, ClassNotFoundException {
        System.out.println("we have finished quiz");
        time.stop();
        DatabaseOperations.storeQuizData(WordBuilder.getCurrentUser(), score_retention, score_width, score_depth);
        
        ShowAnalysis show=new ShowAnalysis(questions_asked, answers);
        
        
        this.dispose();
        show.setVisible(true);
        System.out.println("quiz is finished");
    }
    
    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            time_remaining--;
            if(time_remaining>0)
            jLabel2.setText(" "+getTime(time_remaining));
            else try {
                finishQuiz();
            } catch (SQLException ex) {
                Logger.getLogger(QuizRD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QuizRD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private String getTime(int time_remaining) {
            int min=time_remaining/60;
            int sec=time_remaining%60;
            String temp="";
            String ret;
            if(sec<10){
                temp="0"+sec;
                ret=""+min+":"+temp;
                return ret;
            }
             ret=""+min+":"+sec;
            return ret;
        }
        
    }
    
    
    public boolean checkAnswer(String word_asked, String answered) throws SQLException, ClassNotFoundException {

        /*
         if(current_quiz.equals("w"))
         {   j_width++; System.out.println("j width "+j_width);
           
         }
         */

        String answ = this.answer.getText();
     //   System.out.println("ques asked " + word_asked);
       // System.out.println("answered " + answered);
       // System.out.println(answered.equalsIgnoreCase(word_asked));
        if (answ.equalsIgnoreCase(word_asked)) {
         //   System.out.println("answer is correct");
            quiz_score++;
            last_answer = true;

            
             if(questions_asked.size()>(2*no_of_questions)){
             counter_depth++;
           //      System.out.println("counter_depth "+counter_depth);
             }
             

            //return true;
        } else {
             counter_depth=0;
            last_answer = false;
            //return false;
        }

        //**************************************Score generation
        
       if (words_asked.size() > 0 && words_asked.size() <= no_of_questions) {
            score_retention=quiz_score;
       }
       else if(words_asked.size() > no_of_questions && words_asked.size() <= 2 * no_of_questions) {
            score_width=quiz_score-score_retention;
       }
       else if (words_asked.size() > 2 * no_of_questions && words_asked.size() <= 3 * no_of_questions){
            score_depth=quiz_score-(score_width+score_retention);
       }
       
        
        
        
        
        //*********************************************
        
        
        //loading new questions per section

        if (words_asked.size() >= 0 && words_asked.size() < no_of_questions) {

            j_retention++;
            generateRetentionQuiz();
            //System.out.println("retention " + j_retention);
            
        } else if (words_asked.size() >= no_of_questions && words_asked.size() < 2 * no_of_questions) {
           
            if (words_asked.size() == no_of_questions) {
                c = 0;
            //    score_retention=quiz_score;
                System.out.println("ret"+score_retention);
                
           //     System.out.println(" Retention score "+score_retention);
            }

            generateWidthQuiz();
            j_width++;

           // System.out.println("width " + j_width);
        } else if (words_asked.size() >= 2 * no_of_questions && words_asked.size() < 3 * no_of_questions) {

            if(words_asked.size() == 2 * no_of_questions) {
                //score_width=quiz_score-score_retention;
            
                System.out.println("width score "+score_width);
            }
            generateDepthQuiz();
            j_depth++;
        } else if (words_asked.size() == 3 * no_of_questions) {
          //  score_depth=quiz_score-(score_width+score_retention);
            System.out.println("depth "+score_depth);
            
            finishQuiz();
            
   //         System.out.println("depth score "+score_depth);
            //show analysis
            for (int i = 0; i < questions_asked.size(); i++) {
                
            System.out.println(questions_asked.get(i));
            }
            System.out.println("\n\n\n"+answers);
            
        }

        return last_answer;
    }

    public void startQuiz() throws SQLException, ClassNotFoundException {
        timerlabel.setVisible(false);
        hint.setFont(new java.awt.Font("Calibri",1,14));
        jLabel2.setText(null);
        int count = DatabaseOperations.showHistory(WordBuilder.getCurrentUser()).size();
time=new Timer(1000,new TimerListener());
time.start();
    
        System.out.println(DatabaseOperations.getWordsRetention(WordBuilder.getCurrentUser()));
        System.out.println("count is "+count);
        disp_retention = count / no_of_questions;
        System.out.println("disp_ret "+disp_retention);
        // System.out.println(count);
        words_width_list = DatabaseOperations.getWordsWidth();
        disp_width = (DatabaseOperations.getWordsWidth().size() / 2) / no_of_questions;

        userlabel.setText("hello " + WordBuilder.getCurrentUser());
        if (count >= 15) {
            //this.current_quiz = "r";
            words_retention_list = DatabaseOperations.getWordsRetention(WordBuilder.getCurrentUser());
            generateRetentionQuiz();
        } else {
            JOptionPane.showMessageDialog(this, "You have to search atleast 15 words to take the quiz", "Sorry "+WordBuilder.getCurrentUser(), JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
            WordBuilder.mainpage.setVisible(true);
        }

    }

    public void generateRetentionQuiz() throws SQLException, ClassNotFoundException {
        this.quesno.setText("Q:" + (questions_asked.size() + 1));
        this.answer.setText(null);
        this.score.setText("Score " + quiz_score);

        this.question.setText("");
        //  System.out.println("retention quiz");
        String word = null;
        ArrayList<String> ques = new ArrayList<String>();
        String ans = null;


        //ArrayList<String> words_asked=new ArrayList<String>();
        //   System.out.println(words_retention_list.get(c));

        // System.out.println(words_retention_list);


        //words_asked.add(words_retention_list.get(c));

        if (j_retention < no_of_questions) {
            // System.out.println("words asked "+words_asked);

            if (last_answer) {
                c = c + 2 * (1 + (int) (Math.random() * disp_retention));
                //   System.out.println("answer was right and c is "+c);
            } else {
                c += 2;
            }

            while (words_asked.contains(words_retention_list.get(c))) {
                c++;
                c++;
                //   System.out.println("c is " +c);
            }
            //    System.out.println(words_retention_list.get(c));
            word = words_retention_list.get(c);
            // System.out.println("answer is ")+;
            ques = ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q");
            this.question.setText(ques.get(0));
            this.question.setCaretPosition(0);
            questions_asked.add(ques.get(0));

            answers.add(word);

            words_asked.add(words_retention_list.get(c));

            // j_retention++;
            /*System.out.println("j retention "+j_retention);
             if(j_retention==no_of_questions){ //****************earlier 3
             System.out.println("I am here ");
             current_quiz="w";
             words_width_list=DatabaseOperations.getWordsWidth();
             //j=0;
             c=0;
             generateWidthQuiz();
             }*/
        }
        /*
         else   if (j_retention==3){
         System.out.println("I am here ");
         current_quiz="w";
         words_width_list=DatabaseOperations.getWordsWidth();
         //j=0;
         c=0;
         generateDepthQuiz();
         }
         * */
        // System.out.println(j);
        char temp = word.charAt(0);
        char temp1 = word.charAt(word.length() - 1);

        String temp2;
        temp2 = "" + temp;
         if(word.length()==1)
        {
            temp2="*";
            
        }
        if(word.length()==2)
        {
            temp2="**";
            
        }
        else
        {
            for (int i = 0; i < word.length() - 2; i++) {
            temp2 += "*";
        }
            temp2 += temp1;
        }
        
        
        
        hintanswer = temp2;
        this.hint.setText(hintanswer);
        current_word = word;


        //  System.out.println("questions asked and answers\t"+questions_asked+"\n"+answers);
       /*
         String answe=this.answer.getText();
         answe.trim();
         System.out.println("i hae answered "+answe);
         checkAnswer(word, answe);
         */

        //end retention test

    }

    public void generateWidthQuiz() throws SQLException, ClassNotFoundException {
        this.quesno.setText("Q:" + (questions_asked.size() + 1));

        this.answer.setText(null);
        this.score.setText("Score " + quiz_score);

        this.question.setText("");
     //   System.out.println("width quiz");
        String word = null;
        ArrayList<String> ques = new ArrayList<String>();
        String ans = null;


        //ArrayList<String> words_asked=new ArrayList<String>();

       // System.out.println(words_width_list.get(c));

//        System.out.println(words_width_list);


        //words_asked.add(words_retention_list.get(c));

        if (j_width < no_of_questions) {
            // System.out.println("words asked "+words_asked);

            if (last_answer) {
                c = c + 2 * (1 + (int) (Math.random() * disp_width));
  //              System.out.println("answer was right and c is " + c);
            } else {
                c += 2;
            }

            while (words_asked.contains(words_width_list.get(c))) {
                c++;
                c++;
    //            System.out.println("c is " + c);
            }
      //      System.out.println(words_width_list.get(c));
            word = words_width_list.get(c);
            //System.out.println("ques is "+ ApiFetch.getMeaning(WordBuilder.getCurrentUser(), list.get(c), "q"));
            // System.out.println("answer is ")+;
            ques = ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q");
            this.question.setText(ques.get(0));
            this.question.setCaretPosition(0);
            questions_asked.add(ques.get(0));

            answers.add(word);

            words_asked.add(words_width_list.get(c));

            // j_width++;
            //  System.out.println("j width "+j_width);
            /*if(j_width==no_of_questions-1){//******************************earlier 3
             System.out.println("I am here  j width is "+j_width);
             //current_quiz="d";
             //  words_width_list=DatabaseOperations.getWordsWidth();
             //j=0;
             c=0;
             counter_depth=0;
            
             // generateDepthQuiz();
             }*/
        }
        /*
         else   if (j_retention==3){
         System.out.println("I am here ");
         current_quiz="w";
         words_width_list=DatabaseOperations.getWordsWidth();
         //j=0;
         c=0;
         generateDepthQuiz();
         }
         * */
        // System.out.println(j);
        char temp = word.charAt(0);
        char temp1 = word.charAt(word.length() - 1);

        String temp2;
        temp2 = "" + temp;
          if(word.length()==1)
        {
            temp2="*";
            
        }
        if(word.length()==2)
        {
            temp2="**";
            
        }
        else
        {
            for (int i = 0; i < word.length() - 2; i++) {
            temp2 += "*";
        }
            temp2 += temp1;
        }
        
        
        
        hintanswer = temp2;
        this.hint.setText(hintanswer);
        current_word = word;


      //  System.out.println("questions asked and answers\t" + questions_asked + "\n" + answers);

        /*
         String answe=this.answer.getText();
         answe.trim();
         System.out.println("i hae answered "+answe);
         checkAnswer(word, answe);
         */

        //end retention test



        // *******************************trial to be removed perhaps
        /*
         if(1<0){
         this.question.setText("");
         this.score.setText("score "+quiz_score);
         System.out.println("width quiz");
         String word=null;
         ArrayList<String> ques=new ArrayList<String>();
         String ans=null;
        
        
         System.out.println(words_width_list.get(c));
        
         System.out.println(words_width_list);
        
      
         if(j_width<3){
             
         if(last_answer){
         c=c+2*(1+ (int)(Math.random()*6));
         System.out.println("answer was right and c is "+c);
         }
         else
         {
         c+=2;
         }
            
         while(words_asked.contains(words_width_list.get(c))){
         c++;
         c++;
         System.out.println("c is " +c);
         }
         System.out.println(words_width_list.get(c));
         word=words_width_list.get(c);
         ques=ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q");
         this.question.append(ques.get(0));
         words_asked.add(words_width_list.get(c));
         answers.add(word);
         j_width++;
         }
         else{
         current_quiz="d";
         generateDepthQuiz();
         }
         System.out.println(word);
         char temp=word.charAt(0);
         char temp1=word.charAt(word.length()-1);
        
         String temp2;
         temp2=""+temp;
         for (int i = 0; i < word.length()-2; i++) {
         temp2+="-";
         }
         temp2+=temp1;
         hintanswer=temp2;
         this.hint.setText(hintanswer);
         current_word=word;
       
      
         }
         * */
        //trial end

    }

    public void generateDepthQuiz() throws SQLException, ClassNotFoundException {
        this.question.setText(null);
        this.quesno.setText("Q:" + (questions_asked.size() + 1));
        this.answer.setText(null);
        this.score.setText("Score " + quiz_score);

        //System.out.println("depth quiz");
        ArrayList<String> ques = new ArrayList<String>();
        int i;
        String word;
        String temp_word = null;
        String hint_word="";

        /*
         if(j_depth<no_of_questions){
         if(counter_depth>0 && counter_depth<3 ){
         word=words_asked.get((words_asked.size()-counter_depth));
         ques=ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word,"q");
         size_depth=ques.size()-2;
                
         int j=2;
         while (j<=ques.size()) {
         temp_word=ques.get(j);
         if(words_asked.contains(temp_word)) ;
         else break;
         }
         this.question.append(ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q").get(0));
         questions_asked.add(ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q").get(0));
         hint_word=""+temp_word.charAt(0);
         for (int k = 0; k < temp_word.length()-2; k++) {
         hint_word+="^";
         }
         hint_word+=temp_word.charAt(temp_word.length()-1);
                
         this.hint.setText(hint_word);
                
         }
               
         }*/

        if (j_depth < no_of_questions) {
      //      System.out.println("j depth "+ j_depth);
            if (counter_depth == 0) {
                while (true) {
                   
                    //if(j_depth==0)
                  //word="Thursday";
                    //else
                    word = DatabaseOperations.getRandomWordFromAll();
                    
                    //if( ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q").size()<3 );
                    
                    if (words_asked.contains(word) ); 
                    else {
                        break;
                    }
                }
                System.out.println("word is "+word+" and counter depth is"+counter_depth);
                this.question.setText(ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q").get(0));
                this.question.setCaretPosition(0);  //scroll up
                System.out.println("question:"+ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q").get(0));
                questions_asked.add(ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q").get(0));
                words_asked.add(word);
                answers.add(word);
                current_word = word;

                if(word.length()>2){
                hint_word = "" + word.charAt(0);
                for (int k = 0; k < word.length() - 2; k++) {
                    hint_word += "*";
                }
                hint_word += word.charAt(word.length() - 1);
                }
                else
                {
                    for (int j = 0; j < word.length(); j++) {
                        hint_word+="*";
                    }
                }
                
                this.hint.setText(hint_word);

                                
            } else if (counter_depth != 0 ) {

                
                word = words_asked.get((words_asked.size() - counter_depth));
                
                
                ques = ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q");
                //size_depth=ques.size()-1;
        //        System.out.println("word   sadfaldf "+word);
                
                               
                int j = 1;
                while (j < ques.size()) {
                    temp_word = ques.get(j);
                    if (words_asked.contains(temp_word)) {
                        
                        j++;
                    } else {
                        
          //      System.out.println("temp word"+temp_word);
                    
                this.question.setText(ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q").get(0));
                this.question.setCaretPosition(0);  //scroll up
                questions_asked.add(ApiFetch.getMeaning(WordBuilder.getCurrentUser(), word, "q").get(0));
                words_asked.add(temp_word);
                answers.add(temp_word);
                current_word = temp_word;
                System.out.println("temp word "+temp_word);
                
                
                
                if(temp_word.length()>2){
                hint_word = "" + temp_word.charAt(0);
                for (int k = 0; k < temp_word.length() - 2; k++) {
                    hint_word += "*";
                }
                hint_word += temp_word.charAt(word.length() - 1);
                }
                else
                {
                    for (int k = 0; k < temp_word.length(); k++) {
                        hint_word+="*";
                    }
                }
                
                this.hint.setText(hint_word);

                /*
                
                hint_word = "" + temp_word.charAt(0);
                for (int k = 0; k < temp_word.length() - 2; k++) {
                    hint_word += "*";
                }
                hint_word += temp_word.charAt(temp_word.length() - 1);

                this.hint.setText(hint_word);
                */
                        break;
                    }
                    
                    if (j == ques.size() ) {
                        counter_depth = 0;
                        generateDepthQuiz();    //if all synonyms have been searched
                        break;
                    }
                }
                    
                //counter_depth = 0;
                //generateDepthQuiz(); //if has no synonyms eg. mat

            }
            
            /*
            else
            {
                counter_depth = 0;
                generateDepthQuiz(); //if has no synonyms eg. mat
            }
            * */
        }

    }

    WindowAdapter windowadapter;
    /**
     * Creates new form QuizRD
     */
    public QuizRD() {
        initComponents();
        this.setLocation(scrSize.width - (scrSize.width)/2 - (this.getWidth())/2 ,scrSize.height -(scrSize.height*1)/2 - (this.getHeight())/2  );
        
         windowadapter = new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                
                
                BackGround.exitBG();
        
        System.exit(0);
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

        panel1 = new java.awt.Panel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        quesno = new javax.swing.JLabel();
        score = new javax.swing.JLabel();
        userlabel = new javax.swing.JLabel();
        timerlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        hint = new javax.swing.JLabel();
        answer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz");
        setResizable(false);

        quesno.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        quesno.setText("Q");

        score.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        score.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/score3.png"))); // NOI18N
        score.setText("Score: ");

        userlabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        userlabel.setText("Hello ");

        question.setEditable(false);
        question.setColumns(20);
        question.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        question.setRows(5);
        question.setWrapStyleWord(true);
        jScrollPane1.setViewportView(question);
        question.setLineWrap(true);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Hint:");

        answer.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Ans");

        next.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        next.setText("Next");
        next.setIconTextGap(12);
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(next)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hint, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(timerlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quesno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userlabel)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(111, 111, 111)
                            .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(userlabel)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timerlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(quesno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hint)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:

        current_answer = answer.getText();
        try {
            checkAnswer(current_word, current_answer);
        } catch (SQLException ex) {
            Logger.getLogger(QuizRD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizRD.class.getName()).log(Level.SEVERE, null, ex);
        }





    }//GEN-LAST:event_nextActionPerformed

    private void answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerActionPerformed
        // TODO add your handling code here:
        this.next.doClick();
    }//GEN-LAST:event_answerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuizRD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizRD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizRD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizRD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizRD().setVisible(true);
            }
        });
    }
    Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer;
    private javax.swing.JLabel hint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton next;
    private java.awt.Panel panel1;
    private javax.swing.JLabel quesno;
    private javax.swing.JTextArea question;
    private javax.swing.JLabel score;
    public static javax.swing.JLabel timerlabel;
    private javax.swing.JLabel userlabel;
    // End of variables declaration//GEN-END:variables
}
