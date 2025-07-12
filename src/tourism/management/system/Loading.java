/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String usern;
     public void run(){
        try{
           for(int i=1; i<=101; i++){
               int max = bar.getMaximum();
               int value = bar.getValue();
               
               if(value < max){
                   bar.setValue(bar.getValue()+1);
               }else{
                   setVisible(false);
                   new Dashboard(usern);
               }
               Thread.sleep(50);
           } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
    Loading(String user){
        this.usern=user;
        t = new Thread(this);
        
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(50,20,600,40);
        text.setBackground(Color.blue);
        text.setFont(new Font("SAN_SERIF", Font.BOLD, 35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading, Please wait...");
        loading.setBounds(230,130,150,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(loading);
        
        JLabel username = new JLabel("welcome " + usern);
        username.setBounds(230,310,400,40);
        username.setBackground(Color.RED);
        username.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(username);
        
        t.start();
        setVisible(true);
    }
    
   
    public static void main(String args[]){
        new Loading("");
    }
}
