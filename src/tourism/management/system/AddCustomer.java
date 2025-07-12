
package tourism.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

import java.awt.Choice;
import java.awt.Color;
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

public class AddCustomer extends JFrame implements ActionListener{
    JLabel labelusername, labelname;
    JTextField tfname, tfaddress, tfcountry, tfphone, tfemail, tfnumber;
    JButton add, back;
    Choice ch;
    JRadioButton rmale, rfemale;
    AddCustomer(String usern){
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel username = new JLabel("Username");
        username.setBounds(30,15,150,25);
        add(username);
        
        labelusername = new JLabel(usern);
        labelusername.setBounds(200,15,150,25);
        add(labelusername);
        
        JLabel userid = new JLabel("UserId");
        userid.setBounds(30,65,150,25);
        add(userid);
        
        ch = new Choice();
        ch.setBackground(Color.white);
        ch.setBounds(200,65,150,25);
        ch.add("Adhar Card");
        ch.add("Voter ID");
        ch.add("Birth certificate");
        ch.add("Pan card");
        add(ch); 
        
        JLabel idnumber = new JLabel("ID Number");
        idnumber.setBounds(30,115,150,25);
        add(idnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,115,150,25);
        add(tfnumber);
        
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,165,150,25);
        add(name);
        
        labelname = new JLabel();
        labelname.setBounds(200,165,150,25);
        add(labelname);
        
        
        
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,215,150,25);
        add(gender);
        
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.white);
        rmale.setBounds(200,215,70,25);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.white);
        rfemale.setBounds(280,215,70,25);
        add(rfemale);
        
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
        
        
        add = new JButton("ADD");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(60,465,100,25);
        add.addActionListener(this);
        add(add);
        
        
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
            String query = "select * from account where username = '"+labelusername.getText()+"'";
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
        if(ae.getSource() == add){
            String username = labelusername.getText();
            String id = (String) ch.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender=null;
            if(rmale.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            try{
                String query = "insert into customer values ('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+email+"', '"+phone+"')" ;
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else{
            setVisible(false);
        }
    }
    
    
    public static void main(String args[]){
        new AddCustomer("");
    }
}
