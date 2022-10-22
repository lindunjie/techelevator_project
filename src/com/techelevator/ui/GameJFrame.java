package com.techelevator.ui;

import com.sun.jdi.event.EventIterator;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    //now create 2 dim int array 3x3
    int data[][] = new int[3][3];

    //locate 0 by xy
    int x=0;
    int y = 0;

    public GameJFrame() {
        //init the frame
        initJFrame();

        initData();

        //init the menu bar
        initJMenuBar();

        initImage();


        //by default it's invisible .
        this.setVisible(true);


    }

    private void initData() {
        int[] temArrary = {0, 1, 2, 3, 4, 5, 6, 7, 8};
////   [3,0,4,2,1,5,8,7]
        Random r = new Random();
        for (int i = 0; i < temArrary.length; i++) {
            //generate any int from 0-8; then swich to the ith number to random number
            int index = r.nextInt(temArrary.length);
            int tem = temArrary[i];
            temArrary[i] = temArrary[index];
            temArrary[index] = tem;
        }

/*
        int z = 0;
        //locate 0 by xy

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                data[i][j] = temArrary[z];
                z++;
                if(temArrary[z]==0){
                    x = i;
                    y = j;
                }
            }

        }

*/
        for (int i =0; i < temArrary.length; i++){
            if (temArrary[i] ==0){
                x = i/3;
                y = i%3;
            }
            data[i/3][i%3] = temArrary[i];
        }
    }

    private void initImage() {
        ///remove exist pics.
        this.getContentPane().removeAll();

/*       ///// create imageicon object
        ImageIcon icon1 = new ImageIcon("C:\\Users\\223\\IdeaProjects\\puzzleGame\\photo\\" + number+".jpg");
       /// create jlabel object
        JLabel jLabel1 = new JLabel(icon1);

        jLabel1.setBounds(0,0,150,140);
        //add the to screen
        this.add(jLabel1);

        this.getContentPane().add(jLabel1);
        *
 *///[3,0,4,2,1,5,8,7]
        int number = 1;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon("photo\\" + num + ".jpg"));

                jLabel.setBounds(150 * i, 150 * j, 150, 150);
                // add the to screen


                this.getContentPane().add(jLabel);
                //change the different files
                ;
            }

        }
        /// background setting
        JLabel background = new JLabel(); ///add picture here
        background.setBounds(50,50,500,500);
        // add the background pic to the frame
        this.getContentPane().add(background);

        //refresh the frame
        this.getContentPane().repaint();


    }

    private void initJMenuBar() {
        //create menu bar
        JMenuBar jMenuBar = new JMenuBar();

        // create the object in the bar(function, about)
        JMenu functionJMenu = new JMenu("Function");
        JMenu aboutJMenu = new JMenu("about");


        //create the item
        JMenuItem replayItem = new JMenuItem("replay");
        JMenuItem reloginItem = new JMenuItem("relogin");
        JMenuItem closeItem = new JMenuItem("close");


        JMenuItem contactItem = new JMenuItem("contact");
        //add the items to the bar
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(contactItem);

        //now add the bar to menu
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //size of frame
        this.setSize(600, 700);
        ////set title

        this.setTitle("Dunjie lin's puzzle game");

        this.setAlwaysOnTop(true);  //it will show on the top

        this.setLocationRelativeTo(null);


        this.setDefaultCloseOperation(3);

        this.setLayout(null);

        //add the key listener for the frame.

        this.addKeyListener(this);
     }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //left 37  up 38   r39 down 40

        //a \

        int code = e.getKeyCode();
        System.out.println(code);
        if (code == 38){
            System.out.println("move up");
            if (y == 2){
                return;
            }
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            initImage();
        }else if (code == 37){
            System.out.println("move left");
            if (x == 2){
                return;
            }
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            //then change to the latest format in the frame now
            initImage();
        }else if (code == 40){
            System.out.println("move down");
            if (y == 0){
                return;
            }
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            initImage();

        }else if (code == 39){
            System.out.println("right");
            if (x == 0){
                return;
            }
            data[x][y]=data[x-1][y];
            data[x-1][y] =0;
            x--;
            initImage();
        }




    }
}
