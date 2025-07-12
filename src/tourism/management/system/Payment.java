/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Payment extends JFrame implements ActionListener{
    JButton back, pay;
    Payment(){
        setBounds(300,50,800,600);
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,800,600);
        
        
        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.setBounds(20,20,100,30);
        back.addActionListener(this);
        l1.add(back);
        
        pay = new JButton("Pay");
        pay.setBackground(Color.blue);
        pay.setForeground(Color.white);
        pay.setBounds(150,20,100,30);
        pay.addActionListener(this);
        l1.add(pay);
        
        add(l1);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        if(ae.getSource()==pay){
            new Paytm();
        }
    }
    
    public static void main(String args[]){
        new Payment();
    }
}
