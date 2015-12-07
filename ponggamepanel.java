// Programmer's name:   Linh Cao
// Email address:       linhcao@csu.fullerton.edu
// Course:              CPSC 223j
// Assignment number:   5
// Due date:            Nov 30, 2015
// Title:               Ricochet Ball
// Purpose:             To control the direction of motion of a moving object in real time
// This file name:      ricochetballpanel.java

// Note: some codes in this file are original from "Linearball" provided by professor.

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;


public class ponggamepanel extends JPanel
{    int widthofgraphicalarea;
     int heightofgraphicalarea;
     final int ballradius = 7;
     final int balldiameter = 2*ballradius;
     double realx;
     double realy;
     int x = 493 ;
     int y = 220;
     double deltax;
     double deltay;
     double defaultdx;
     double defaultdy;
     double angle = 90;

     int paddleheight = 6;   //Paddle has height of 6 pixels
     int paddlewidth;
     int leftx =0;
     int lefty = 200;
     int rightx = 994;
     int righty = 217;
     int paddspeed =5;

     ponggamepanel()
     {}

     public void paintComponent(Graphics graphicarea)
     {    super.paintComponent(graphicarea);
          this.setBackground(Color.BLUE);
          widthofgraphicalarea = getWidth();
          heightofgraphicalarea = getHeight();
          graphicarea.setColor(Color.BLACK);
          graphicarea.drawLine(widthofgraphicalarea/2,0,widthofgraphicalarea/2,heightofgraphicalarea);
          graphicarea.setColor(Color.RED);
          graphicarea.fillOval(x,y,balldiameter,balldiameter);
          graphicarea.setColor(Color.BLACK);
          paddlewidth = widthofgraphicalarea / 14;
          graphicarea.fillRect(leftx,lefty,paddleheight,paddlewidth);
          graphicarea.fillRect(rightx,righty,paddleheight,paddlewidth);
     }//End of method paintComponent

     public void setDelta(double direction, double speed, double anirate)
     {
        angle += direction;
        deltax = speed * Math.sin(Math.toRadians(angle))/anirate;
        deltay = speed * Math.cos(Math.toRadians(angle))/anirate;
        defaultdx= deltax;
        defaultdy = deltay;
     }


     public void reset()
     {    realx = (double)(widthofgraphicalarea/2 - ballradius);
          realy = (double)(heightofgraphicalarea/2 - ballradius);
          x = (int)realx;
          y = (int)realy;
          lefty = 217;
          righty = 217;
          paddspeed = 5;
          deltax = defaultdx;
          deltay = defaultdy;
          repaint();
     }//End of initializeball

     // this function will return 1 if player left win, 2 for player right, and 0 if no win yet
     public int moveball()
     {    
          if(x<=6 && y>lefty && y<(lefty+paddlewidth)){
            deltax*=1.5;
            deltay*=1.5;
            paddspeed +=5;
            deltax = -deltax;
          } else if(x<0){
            return 2;
          } else if((x + balldiameter)>=widthofgraphicalarea-6 && y>righty && y<(righty+paddlewidth)){
            deltax*=1.5;
            deltay*=1.5;
            paddspeed +=5;
            deltax = -deltax;
          } else if(x>widthofgraphicalarea){
            return 1;
          } else if(y<0 || y + ballradius+ balldiameter >heightofgraphicalarea){
            deltay = -deltay; // bound back
          }
          realx = realx + deltax;
          realy = realy + deltay;
          x = (int)Math.round(realx);
          y = (int)Math.round(realy);

          return 0;

     }//End of moveball

     public void moveup(int player)
     {
        if(player == 1){
          if(lefty > paddspeed){
            lefty -=paddspeed;
          }
        } else{
          if(righty > paddspeed){
            righty -=paddspeed;
          }
        }
     }

     public void movedown(int player)
     {
        if(player == 1){
          if(lefty + paddlewidth < heightofgraphicalarea-paddspeed){
            lefty +=paddspeed;
          }
        } else{
          if(righty + paddlewidth < heightofgraphicalarea-paddspeed){
            righty +=paddspeed;
          }
        }

     }


}//End of Graphicalpanel
