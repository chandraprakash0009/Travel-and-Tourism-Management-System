/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,30,250,250);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        // username
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,150,25);
        username.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(username);
        
        tfusername = new JTextField();
        tfusername.setBounds(200,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
      
        // search button for name and security question
        search = new JButton("Search");
        search.setBounds(370,20,100,25);
        search.setBackground(Color.yellow);
        search.setForeground(Color.red);
        search.addActionListener(this);
        p1.add(search);
        
        
        // name
        JLabel name = new JLabel("Name");
        name.setBounds(40,55,150,25);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(name);
        
        tfname = new JTextField();
        tfname.setBounds(200,55,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        // security question
        JLabel question = new JLabel("Security Question");
        question.setBounds(40,90,150,25);
        question.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(question);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(200,90,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        // answer
        JLabel answer = new JLabel("Answer");
        answer.setBounds(40,125,150,25);
        answer.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(answer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(200,125,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        // button to retrieve
        retrieve = new JButton("Retrieve");
        retrieve.setBounds(370,125,100,25);
        retrieve.setBackground(Color.yellow);
        retrieve.setForeground(Color.red);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        // getting password
        JLabel password = new JLabel("Password");
        password.setBounds(40,160,150,25);
        password.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(password);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(200,160,150,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        // back buttton
        back = new JButton("Back");
        back.setBounds(150,220,100,25);
        back.setBackground(Color.yellow);
        back.setForeground(Color.red);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    String n = rs.getString("name");
                    tfname.setText(n);
                    
                    String que = rs.getString("ch");
                    tfquestion.setText(que);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==retrieve){
            try{
                String query = " select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"' ";
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    String n = rs.getString("password");
                    tfpassword.setText(n);
                    
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(true);
            new Login();
        }
    }
    
    
    public static void main(String args[]){
        new ForgetPassword();
    }
}
