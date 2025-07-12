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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DeletePersonalDetail extends JFrame implements ActionListener{
    JButton back, delete;
    String username;
    DeletePersonalDetail(String username){
        this.username=username;
        setBounds(300,50,900,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        // heading for username
        JLabel lbl = new JLabel("Username");
        lbl.setBounds(50,50,150,25);
        add(lbl);
        // get username from database and set it to below label
        JLabel labelusername = new JLabel();
        labelusername.setBounds(210,50,150,25);
        add(labelusername);
        
        // heading of id which has been used
        JLabel id = new JLabel("ID");
        id.setBounds(50,90,150,25);
        add(id);
        // get from database that which id has been used
        JLabel labelid = new JLabel();
        labelid.setBounds(210,90,150,25);
        add(labelid);
        
        // heading for id number
        JLabel ID_number = new JLabel("ID Number");
        ID_number.setBounds(50,130,150,25);
        add(ID_number);
        // get id number from database
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(210,130,150,25);
        add(labelnumber);
        
        // heading for name
        JLabel name = new JLabel("Name");
        name.setBounds(50,170,150,25);
        add(name);
        // get name from from database 
        JLabel labelname = new JLabel();
        labelname.setBounds(210,170,150,25);
        add(labelname);
        
        // heading for gender
        JLabel gender = new JLabel("Gender");
        gender.setBounds(50,210,150,25);
        add(gender);
        // get gender from from database 
        JLabel labelgender = new JLabel();
        labelgender.setBounds(210,210,150,25);
        add(labelgender);
        
        // heading for country
        JLabel country = new JLabel("Country");
        country.setBounds(520,50,150,25);
        add(country);
        // get country from from database 
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(700,50,150,25);
        add(labelcountry);
        
        // heading for address
        JLabel address = new JLabel("Address");
        address.setBounds(520,90,150,25);
        add(address);
        // get gender from from database 
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(700,90,150,25);
        add(labeladdress);
        
        // heading for phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(520,130,150,25);
        add(phone);
        // get gender from from database 
        JLabel labelphone = new JLabel();
        labelphone.setBounds(700,130,150,25);
        add(labelphone);
        
        // heading for phone
        JLabel email = new JLabel("Email");
        email.setBounds(520,170,150,25);
        add(email);
        // get gender from from database 
        JLabel labelemail = new JLabel();
        labelemail.setBounds(700,170,150,25);
        add(labelemail);
        
        back = new JButton("BACK");
        back.setBounds(250, 270, 100, 50);
        back.addActionListener(this);
        add(back);
        
        delete = new JButton("Delete");
        delete.setBounds(400, 270, 100, 50);
        delete.addActionListener(this);
        add(delete);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,300,600,300);
        add(image);
        
        
        try{
            Conn c = new Conn();
            String query = "select * from customer where username='"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("userID"));
                labelnumber.setText(rs.getString("IDnumber"));
                labelname.setText(rs.getString("customerName"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            return;
        }
        try{
            Conn c = new Conn();
            String query = "DELETE FROM customer WHERE username = '"+username+"';";
            c.s.executeUpdate("DELETE FROM customer WHERE username = '"+username+"';");
            c.s.executeUpdate("DELETE FROM account WHERE username = '"+username+"';");
            c.s.executeUpdate("DELETE FROM bookedPackage WHERE username = '"+username+"';");
            c.s.executeUpdate("DELETE FROM bookedHotel WHERE username = '"+username+"';");
            JOptionPane.showMessageDialog(this, "Details deleted successfully");
            System.exit(0);
        }catch(Exception e){
            System.out.print(e);
        }
    }
    
    public static void main(String args[]){
        new DeletePersonalDetail("");
    }
}
