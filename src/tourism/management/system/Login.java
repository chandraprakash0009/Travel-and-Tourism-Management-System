/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
        JButton signup, login,password;
        JTextField tfpassword, tfusername;
        Login(){
            
            // making a frame
            setSize(900,400);
            setLocation(350,200);
            setLayout(null); 
            getContentPane().setBackground(Color.white);
            
            // making a pannel to paste a photo
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(131,193,233));
            p1.setBounds(0,0,400,400);  // startingPointFromLeft-startingPointFromTop-length of this pannel-width of this pannel
            p1.setLayout(null);
            add(p1);
            
            // adding photo on the panel
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
            Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(100,120,200,200);
            p1.add(image);
            
            // making second panel to enter the input
            JPanel p2 = new JPanel();
            p2.setLayout(null);
            p2.setBounds(400,30,450,300);
            add(p2);
            
            // in second panel, adding heading for username to take input
            JLabel lblusername = new JLabel("Username");
            lblusername.setBounds(60,20,100,25);
            lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            p2.add(lblusername);
            
            // adding textarea for username
            tfusername = new JTextField();
            tfusername.setBounds(60,60,300,30);
            lblusername.setBorder(BorderFactory.createEmptyBorder());
            p2.add(tfusername);
            
            // again doing the same thing for password
            // label for password heading
            JLabel lblpassword = new JLabel("Password");
            lblpassword.setBounds(60,100,100,25);
            lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            p2.add(lblpassword);
            
            // adding textarea for password
            tfpassword = new JTextField();
            tfpassword.setBounds(60,135,300,30);
            tfpassword.setBorder(BorderFactory.createEmptyBorder());
            p2.add(tfpassword);
            
            // now adding button for "login"
            login = new JButton("login");
            login.setBounds(60,190,100,30);
            login.setBackground(new Color(131,193,233));
            login.setForeground(Color.white);
            login.setBorder(BorderFactory.createEmptyBorder());
            login.addActionListener(this);
            p2.add(login);
            
            // adding "sign-up" button
            signup = new JButton("signup");
            signup.setBounds(180,190,100,30);
            signup.setBackground(new Color(131,193,233));
            signup.setForeground(Color.white);
            signup.setBorder(BorderFactory.createEmptyBorder());
            signup.addActionListener(this);
            p2.add(signup);
            
            //adding forget-password button
            password = new JButton("Forget Password");
            password.setBounds(130,230,100,30);
            password.setBackground(new Color(131,193,233));
            password.setForeground(Color.white);
            password.setBorder(BorderFactory.createEmptyBorder());
            password.addActionListener(this);
            p2.add(password);
            //adding some text in front of forget-password button
            JLabel text = new JLabel("Trouble in login...");
            text.setBounds(240,230,100,30);
            text.setForeground(Color.red);
            p2.add(text);
            
            
            setVisible(true);
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == login){
                try{
                    String username = tfusername.getText();
                    String pass = tfpassword.getText();
                    
                    String query = "select * from account where username= '"+username+"' AND password= '"+pass+"'";
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Loading(username);
                    }else{
                        JOptionPane.showMessageDialog(null, "incorrect username or password");
                    }
                     
                }catch(Exception e){
                    System.out.println(e);
                }
            }else if(ae.getSource()==signup){
                setVisible(false);
                new Signup();
            }else{
                setVisible(false);
                new ForgetPassword();
            }
        }
    
    public static void main(String args[]){
        new Login();
    }
}
