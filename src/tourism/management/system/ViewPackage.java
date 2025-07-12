/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    JLabel labelpackage, labelperson,labelid, labelidnumber, labelphone, labelprice;
    ViewPackage(String username){
        setBounds(300,50,900,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 350,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450,40,350,350);
        add(la1);
        
        // heading for username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50,50,150,25);
        add(lblusername);
        // get username from database and set it to below label
        JLabel labelusername = new JLabel(username);
        labelusername.setBounds(210,50,150,25);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(50,90,150,25);
        add(lblpackage);
        
         labelpackage = new JLabel();
        labelpackage.setBounds(210,90,150,25);
        add(labelpackage);
        
        JLabel lblperson = new JLabel("Person");
        lblperson.setBounds(50,130,150,25);
        add(lblperson);
        
        labelperson = new JLabel();
        labelperson.setBounds(210,130,150,25);
        add(labelperson);
        
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(50,170,150,25);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(210,170,150,25);
        add(labelid);
        
        
        
        JLabel lblidnumber = new JLabel("ID Number");
        lblidnumber.setBounds(50,210,150,25);
        add(lblidnumber);
        
        labelidnumber = new JLabel();
        labelidnumber.setBounds(210,210,150,25);
        add(labelidnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50,250,150,25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(210,250,150,25);
        add(labelphone);
        
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(50,290,150,25);
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setBounds(210,290,150,25);
        add(labelprice);
        
        try{
            Conn c = new Conn();
            String query = "select * from bookedPackage where username = '"+username+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelpackage.setText(rs.getString("package"));
                labelperson.setText(rs.getString("person"));
                labelid.setText(rs.getString("ID"));
                labelidnumber.setText(rs.getString("IDnumber"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.setBounds(100,350,100,30);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String args[]){
        new ViewPackage("");
    }
}
