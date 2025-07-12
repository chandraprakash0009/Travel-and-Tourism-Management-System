/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;



import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UpdateDetail extends JFrame implements ActionListener {
    JLabel labelusername, labelname;
    JTextField tfname, tfaddress, tfcountry, tfphone, tfemail, tfnumber,tfgender;
    JButton update, back;
    Choice ch;
    JRadioButton rmale, rfemale;
    UpdateDetail(String usern){
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("Update Customer Details");
        text.setFont(new Font("SAN_SERIF", Font.BOLD, 40));
        text.setBounds(200,0,500,50);
        add(text);
        
        JLabel username = new JLabel("Username");
        username.setBounds(30,80,150,25);
        add(username);
        
        labelusername = new JLabel();
        labelusername.setBounds(200,80,150,25);
        add(labelusername);
        
        JLabel userid = new JLabel("UserId");
        userid.setBounds(30,115,150,25);
        add(userid);
        
        ch = new Choice();
        ch.setBackground(Color.white);
        ch.setBounds(200,115,150,25);
        ch.add("Adhar Card");
        ch.add("Voter ID");
        ch.add("Birth certificate");
        ch.add("Pan card");
        add(ch); 
        
        JLabel idnumber = new JLabel("ID Number");
        idnumber.setBounds(30,150,150,25);
        add(idnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,150,150,25);
        add(tfnumber);
        
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,185,150,25);
        add(name);
        
        labelname = new JLabel();
        labelname.setBounds(200,185,150,25);
        add(labelname);
        
        
        
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,215,150,25);
        add(gender);
        
        tfgender = new JTextField();
        tfgender.setBounds(200,215,150,25);
        add(tfgender);
        
        ButtonGroup group = new ButtonGroup();
        group.add(rmale);
        group.add(rfemale);
        
        
        
        JLabel country = new JLabel("Country");
        country.setBounds(30,265,150,25);
        add(country);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,265,150,25);
        add(tfcountry);
        
        
        JLabel address = new JLabel("Address");
        address.setBounds(30,315,150,25);
        add(address);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,315,150,25);
        add(tfaddress);
        
        
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(30,365,150,25);
        add(phone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,365,150,25);
        add(tfphone);
        
        
        
        JLabel email = new JLabel("Email");
        email.setBounds(30,415,150,25);
        add(email);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,415,150,25);
        add(tfemail);
        
        
        update = new JButton("UPDATE");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(60,465,100,25);
        update.addActionListener(this);
        add(update);
        
        
        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(195,465,100,25);
        back.addActionListener(this);
        add(back);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon  i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);
        
        
        try{
            String query = "select * from account where username = '"+usern+"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String username = labelusername.getText();
            String id = (String) ch.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender=tfgender.getText();
//            if(rmale.isSelected()){
//                gender = "Male";
//            }else{
//                gender = "Female";
//            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            try{
                Conn c = new Conn();
                String query  = "update customer set userID =  '"+id+"' , IDnumber=  '"+number+"' , gender= '"+gender+"' , country= '"+country+"' , address='"+address+"', email= '"+email+"' , phone= '"+phone+"'" ; 
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new UpdateDetail("");
    }
}
