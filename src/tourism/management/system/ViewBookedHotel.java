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
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewBookedHotel extends JFrame implements ActionListener{
    String username;
    JButton back;
    JLabel labelprice, labelid, labelidnumber, labelphone;
    JLabel labelhotel, labelroomtype, labelfood, labelperson, labeldays;;
    ViewBookedHotel(String username){
        this.username=username;
        
        setBounds(300,150,1000,600);
        setLayout(null);
        setBackground(Color.white);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(500,80,400,400);
        add(l1);
        
        JLabel heading = new JLabel("Booked Hotel Details");
        heading.setBounds(250,15,500,40);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 30));
        heading.setForeground(Color.red);
        add(heading);
        
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(70,60,150,30);
        add(lblusername);
        
        JLabel lblselecthotel = new JLabel("Hotel Name");
        lblselecthotel.setBounds(70,100,150,30);
        add(lblselecthotel);
        
        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setBounds(70,140,150,30);
        add(lblperson);
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(70,180,150,30);
        add(lbldays);
        
        JLabel lbltype = new JLabel("AC Included ?");
        lbltype.setBounds(70,220,150,30);
        add(lbltype);
        
        JLabel lblfood = new JLabel("Food included ?");
        lblfood.setBounds(70,260,150,30);
        add(lblfood);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(70,300,150,30);
        add(lblid);
        
        JLabel lblidnumber = new JLabel("ID Number");
        lblidnumber.setBounds(70,340,150,30);
        add(lblidnumber);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(70,380,150,30);
        add(lblphone);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(70,420,150,30);
        add(lblprice);
        
        // adding detail
        
        JLabel labelusername = new JLabel(username);
        labelusername.setBounds(300,60, 150, 30);
        add(labelusername);
        
        
        // for hotel selection
        labelhotel = new JLabel();
        labelhotel.setBounds(300,100, 150, 30);
        add(labelhotel);
        
        
        labelperson = new JLabel();
        labelperson.setBounds(300,140, 150, 30);
        //labelperson.setBorder(BorderFactory.createLineBorder(Color.black));
        add(labelperson);
        
        labeldays = new JLabel();
        labeldays.setBounds(300,180, 150, 30);
        //labeldays.setBorder(BorderFactory.createLineBorder(Color.black));
        add(labeldays);
        
        // for room_type
        labelroomtype = new JLabel();
        labelroomtype.setBounds(300,220, 150, 30);
        add(labelroomtype);
   
        // for food
        labelfood = new JLabel();
        labelfood.setBounds(300,260, 150, 30);
        add(labelfood);
        
        
        labelid = new JLabel();
        labelid.setBounds(300,300, 150, 30);
        add(labelid);
        
        labelidnumber = new JLabel();
        labelidnumber.setBounds(300,340, 150, 30);
        add(labelidnumber);
        
        labelphone = new JLabel();
        labelphone.setBounds(300,380, 150, 30);
        add(labelphone);
        
        labelprice = new JLabel();
        labelprice.setBounds(300,420, 150, 30);
        //labelprice.setBorder(BorderFactory.createLineBorder(Color.blue));
        add(labelprice);
        
        
        try{
            Conn c = new Conn();
            
            String s= "select * from bookedHotel where username='"+username+"'";
            ResultSet rs = c.s.executeQuery(s);
            while(rs.next()){
                labelid.setText(rs.getString("ID"));
                labelidnumber.setText(rs.getString("IDnumber"));
                labelphone.setText(rs.getString("Phone"));
                labelprice.setText(rs.getString("TotalPrice"));
                labelhotel.setText(rs.getString("HotelName"));
                labelperson.setText(rs.getString("TotalPerson"));
                labeldays.setText(rs.getString("TotalDays"));
                String room = (rs.getString("ACroom").equals("AC"))? "YES" : "NO";
                labelroomtype.setText(room);
                labelfood.setText(rs.getString("FoodIncluded"));
            }
        }catch(Exception e){
            System.out.print(e);
        }
        
        
        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.setBounds(150,470,100,30);
        back.addActionListener(this);
        add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String args[]){
        new ViewBookedHotel("atulNov14");
    }
}
