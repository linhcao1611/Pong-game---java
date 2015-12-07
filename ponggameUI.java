// Programmer's name:   Linh Cao
// Email address:       linhcao@csu.fullerton.edu
// Course:              CPSC 223j
// Assignment number:   5
// Due date:            Nov 30, 2015
// Title:               Ricochet Ball
// Purpose:             To control the direction of motion of a moving object in real time
// This file name:      ricochetballUI.java

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.*;
import java.lang.String;

public class ponggameUI extends javax.swing.JFrame  {
    public ponggameUI() {
        initComponents();      
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel_top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel_mid = new javax.swing.JPanel();
        panel_bot = new javax.swing.JPanel();
        btn_pause = new javax.swing.JButton("Pause");
        btn_pause.setFocusable(false);
        btn_new = new javax.swing.JButton("New Game");
        btn_new.setFocusable(false);
        btn_quit = new javax.swing.JButton("Quit");
        btn_quit.setFocusable(false);
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_leftscore = new javax.swing.JLabel();
        lb_rightscore = new javax.swing.JLabel();
        lb_winner = new javax.swing.JLabel();
        btn_pause.setEnabled(false);
     

        buttonhandler = new Buttonhandlerclass();
        btn_pause.addActionListener(buttonhandler);
        btn_new.addActionListener(buttonhandler);
        btn_quit.addActionListener(buttonhandler);

        listener = new KeyListenerclass();
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(listener);

        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1400, 1200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("CPSC 223j Assignment 6");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel2.setText("By Linh Cao");

        javax.swing.GroupLayout panel_topLayout = new javax.swing.GroupLayout(panel_top);
        panel_top.setLayout(panel_topLayout);
        panel_topLayout.setHorizontalGroup(
            panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_topLayout.createSequentialGroup()
                .addGap(407, 407, 407)
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(panel_topLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)))
                .addContainerGap(421, Short.MAX_VALUE))
        );
        panel_topLayout.setVerticalGroup(
            panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_topLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanel panel_mid = new JPanel();
        panel_mid.setBounds(0,0,1000,440);
        panel_mid.setPreferredSize(new Dimension(1000,440));
        add(panel_mid);
        gpanel = new ponggamepanel();
        gpanel.setPreferredSize(new Dimension(1000,440));
        panel_mid.add(gpanel);

        btn_pause.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btn_pause.setText("Pause");

        btn_new.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btn_new.setText("New Game");

        btn_quit.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btn_quit.setText("Quit");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel3.setText("Player Left");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel4.setText("Player Right");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel5.setText("Winner");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel6.setText("Score");

        lb_leftscore.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lb_leftscore.setText("0");

        lb_rightscore.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lb_rightscore.setText("0");

        lb_winner.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lb_winner.setText("");

        javax.swing.GroupLayout panel_botLayout = new javax.swing.GroupLayout(panel_bot);
        panel_bot.setLayout(panel_botLayout);
        panel_botLayout.setHorizontalGroup(
            panel_botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_botLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btn_new)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_quit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(66, 66, 66)
                .addGroup(panel_botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_botLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_leftscore, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(lb_rightscore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lb_winner))
                .addGap(137, 137, 137))
        );
        panel_botLayout.setVerticalGroup(
            panel_botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_botLayout.createSequentialGroup()
                .addGroup(panel_botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_botLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(panel_botLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_botLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_leftscore)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_rightscore))
                            .addGroup(panel_botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btn_quit, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addComponent(btn_new, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_pause, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(lb_winner)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_mid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_bot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_mid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_bot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public void getsetValue(){
        speed = 75.0;

        Random rand = new Random();
        int randomangle = rand.nextInt(40) + 20;
        direction = randomangle;

        //Make a clock that controls the graphical refresh rate.
        refreshhandler = new Refreshclass();
        refreshinterval = RefreshInterval(refreshrate);
        refreshclock = new Timer(refreshinterval,refreshhandler);

        //Make a clock that controls the animation rate.
        animationhandler = new Animationclass();
        animationclock = new Timer(animationinterval,animationhandler);

        gpanel.setDelta(direction,speed,rateofanimation);        
    }

     private class Buttonhandlerclass implements ActionListener
     {    public void actionPerformed(ActionEvent event)
              {
                if(event.getSource() == btn_new)
                  {
                    gpanel.reset();
                    leftscore =0;
                    rightscore =0;
                    lb_winner.setText("");
                    lb_leftscore.setText("0");
                    lb_rightscore.setText("0");
                    btn_new.setEnabled(false);
                    btn_pause.setEnabled(true);
                    getsetValue();
                    refreshclock.start();
                    animationclock.start();                   
                  }
                else if (event.getSource() == btn_quit) {
                    System.out.printf("%s\n","Exit program");
                    System.exit(0);
                } else if(event.getSource() == btn_pause){
                    if(btn_pause.getText() == "Pause"){
                        btn_pause.setText("Resume");
                        refreshclock.stop();
                        animationclock.stop();
                    }else if(btn_pause.getText() == "Go"){
                        btn_pause.setText("Pause");
                        refreshclock.start();
                        animationclock.start();
                    }
                }

              }
     }//End of Buttonhandlerclass


     // Idea from stackoverflow
     // Link: http://stackoverflow.com/questions/2623995/swings-keylistener-and-multiple-keys-pressed-at-the-same-time
    private class KeyListenerclass extends KeyAdapter {
        @Override
        public synchronized void keyPressed(KeyEvent e) {


            pressed.add(e.getKeyCode());
            if (pressed.size() > 0) {
                for(Integer temp:pressed){
                    if(temp == KeyEvent.VK_UP ){
                        System.out.printf("%s\n","right player up key");
                        gpanel.moveup(2);
                    }

                    if(temp == KeyEvent.VK_DOWN){
                        System.out.printf("%s\n","right player down key");
                        gpanel.movedown(2);
                    }

                    if(temp == KeyEvent.VK_W){
                        System.out.printf("%s\n","left player up key");
                        gpanel.moveup(1);
                    }

                    if(temp == KeyEvent.VK_S){
                        System.out.printf("%s\n","left player down key");
                        gpanel.movedown(1);
                    }
                }
            }
        }


        @Override
         public synchronized void keyReleased(KeyEvent e) {
            pressed.remove(e.getKeyCode());
         }

        @Override
        public synchronized void keyTyped(KeyEvent e) {
            
        }
      }

     private class Refreshclass implements ActionListener
     {    public void actionPerformed(ActionEvent event)
              {if(event.getSource() == refreshclock)
                {
                  gpanel.repaint();                  
                }
               else
                  System.out.printf("%s\n","Error in the refresh clock.");
              }
     }//end of Refreshclass

     private class Animationclass implements ActionListener
     {    public void actionPerformed(ActionEvent event)
              {if(event.getSource() == animationclock){
                int val = gpanel.moveball();
                if(val == 1){
                    System.out.printf("%s\n","left Scored");
                    leftscore +=1;
                    leftscorestr = String.format("%d", leftscore);
                    lb_leftscore.setText(leftscorestr);
                    if(leftscore == winningscore){
                        lb_winner.setText("Left player");
                        btn_pause.setEnabled(false);
                        btn_new.setEnabled(true);
                    }
                    animationclock.stop();
                    btn_pause.setText("Go");
                    gpanel.reset();
                } else if (val == 2){
                    System.out.printf("%s\n","right Scored");
                    rightscore +=1;
                    rightscorestr = String.format("%d", rightscore);
                    lb_rightscore.setText(rightscorestr);
                    if(rightscore == winningscore){
                        lb_winner.setText("Right player");
                        btn_pause.setEnabled(false);
                        btn_new.setEnabled(true);
                    }
                    animationclock.stop();
                    btn_pause.setText("Go");
                    gpanel.reset();
                }         
              }            
              }
     }//End of Animationclass

     public int RefreshInterval(double value){
        return (int)Math.round(millisecondpersecond/value);
     }


     javax.swing.JButton btn_new;
     javax.swing.JButton btn_pause;
     javax.swing.JButton btn_quit;
     javax.swing.JLabel jLabel1;
     javax.swing.JLabel jLabel2;
     javax.swing.JLabel jLabel3;
     javax.swing.JLabel jLabel4;
     javax.swing.JLabel jLabel5;
     javax.swing.JLabel jLabel6;
     javax.swing.JLabel lb_leftscore;
     javax.swing.JLabel lb_rightscore;
     javax.swing.JLabel lb_winner;
     javax.swing.JPanel panel_bot;
     javax.swing.JPanel panel_mid;
     javax.swing.JPanel panel_top;
     int x;
     int y;
     int leftscore;
     int rightscore;
     double direction;
     double speed;
     ponggamepanel gpanel;
     int refreshinterval;
     Timer refreshclock;
     Timer animationclock;
     Timer upclock;
     Timer downclock;
     String leftscorestr;
     String rightscorestr;
     String winner;
     KeyListenerclass listener;
     Buttonhandlerclass buttonhandler;
     Refreshclass refreshhandler;
     Animationclass animationhandler;

     final double degreesofrotation = 3.0;
     final double refreshrate = 60;
     final double millisecondpersecond = 1000.0;
     final double rateofanimation = 22.5;  
     final int animationinterval = (int)Math.round(millisecondpersecond/rateofanimation);
     final Set<Integer> pressed = new HashSet<Integer>();
     final int winningscore = 5;

}
