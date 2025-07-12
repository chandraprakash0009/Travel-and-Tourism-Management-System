/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener{
    JButton create,back;
    JTextField tfusername, tfname, tfpassword, tfanswer;
    Choice ch;
    Signup(){
        setBounds(300,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // making a pannel
        JPanel p1 = new JPanel();
        p1.setBounds(0,0,400,400);
        p1.setBackground(new Color(133,193,233));
        p1.setLayout(null);
        add(p1);
        
        // adding heading in panel
        
        //adding userrname
        JLabel username = new JLabel("Username");
        username.setBounds(50,20,150,30);
        username.setForeground(Color.white);
        username.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(username);
        // adding textarea for username
        tfusername = new JTextField();
        tfusername.setBounds(200,20,180,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        
         // adding name section
        JLabel name = new JLabel("Name");
        name.setBounds(50,60,150,30);
        name.setForeground(Color.white);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(name);
        // adding textarea for name
        tfname = new JTextField();
        tfname.setBounds(200,60,180,30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        // adding password
        JLabel password = new JLabel("Password");
        password.setBounds(50,100,150,30);
        password.setForeground(Color.white);
        password.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(password);
        // adding textarea for password
        tfpassword = new JTextField();
        tfpassword.setBounds(200,100,180,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        
        // adding security question
        JLabel security = new JLabel("Security Question");
        security.setBounds(50,140,150,30);
        security.setForeground(Color.white);
        security.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(security);
        //adding choice
        ch = new Choice();
        ch.setBounds(200,140,180,30);
        ch.add("Favourite songs");
        ch.add("Place of Birth");
        ch.add("what is the name of your first school");
        p1.add(ch);
        
        
        //adding userrname
        JLabel answer = new JLabel("Answer");
        answer.setBounds(50,180,150,30);
        answer.setForeground(Color.white);
        answer.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(answer);
        // adding textarea for username
        tfanswer = new JTextField();
        tfanswer.setBounds(200,180,180,30);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        // adding create button
        create = new JButton("Create");
        create.setBackground(Color.yellow);
        create.setForeground(Color.red);
        create.setBounds(70,250,100,30);
        create.setFont(new Font("San_SERIF", Font.BOLD, 14));
        create.addActionListener(this);
        p1.add(create);
        
        // adding back button
        back = new JButton("BACK");
        back.setBackground(Color.yellow);
        back.setForeground(Color.red);
        back.setBounds(200,250,100,30);
        back.setFont(new Font("San_SERIF", Font.BOLD, 14));
        back.addActionListener(this);
        p1.add(back);
        
        JPanel p2 = new JPanel();
        p2.setBounds(401,0,400,400);
        add(p2);
        // adding photo on the panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        p1.setLayout(null);
        p2.add(image);
       
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = ch.getSelectedItem();
            String answer = tfanswer.getText();
            
            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "account created successfully");
                
                setVisible(false);
                new Login();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]){
        new Signup();
    }
}

