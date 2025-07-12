
package tourism.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.awt.Choice;
import java.awt.Color;
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
import javax.swing.JTextField;

public class BookPackage extends JFrame implements ActionListener{
    Choice ch;
    String username;
    JTextField labelperson;
    JLabel labelusername, labelid, labelIDnumber, labelphone, labelprice;
    JButton checkPrice, bookPackage, back;
    BookPackage(String username){
        this.username=username;
        //setBounds(400,400,600,600);
        setBounds(300,50,900,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        
         // heading for username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50,50,150,25);
        add(lblusername);
        // get username from database and set it to below label
        labelusername = new JLabel(username);
        labelusername.setBounds(210,50,150,25);
        //labelusername.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        add(labelusername);
        
        // heading of id which has been used
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(50,90,150,25);
        add(lblid);
        // get from database that which id has been used
        labelid = new JLabel();
        labelid.setBounds(210,90,150,25);
        //labelid.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        add(labelid);
        
        // heading for id number
        JLabel lblIDnumber = new JLabel("ID Number");
        lblIDnumber.setBounds(50,130,150,25);
        add(lblIDnumber);
        // get id number from database
        labelIDnumber = new JLabel();
        labelIDnumber.setBounds(210,130,150,25);
        //labelIDnumber.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        add(labelIDnumber);
        
        // heading for phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(50,170,150,25);
        add(phone);
        // get gender from from database 
        labelphone = new JLabel();
        labelphone.setBounds(210,170,150,25);
        //labelphone.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        add(labelphone);
        
        // select package
        JLabel selectPackage = new JLabel("Select package");
        selectPackage.setBounds(50,210,150,25);
        add(selectPackage);
        // add [ackage option
        ch = new Choice();
        ch.add("Gold Package");
        ch.add("Silver Package");
        ch.add("Bronze Package");
        ch.setBounds(210,210,150,25);
        add(ch);
        
        // number of person
        JLabel lblperson = new JLabel("Number of Person");
        lblperson.setBounds(50,250,150,25);
        add(lblperson);
        // get gender from from database 
        labelperson = new JTextField("1");
        labelperson.setBounds(210,250,150,25);
        //labelperson.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        add(labelperson);
        
        // total price
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(50,290,150,25);
        add(lblprice);
        // calculate and  print price
        labelprice = new JLabel();
        labelprice.setBounds(210,290,150,25);
        labelprice.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        add(labelprice);
        
        // establish connection with database and get information from username
        try{
            Conn c = new Conn();
            String query = "select * from customer where username='"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelid.setText(rs.getString("userID"));
                labelIDnumber.setText(rs.getString("IDnumber"));
                labelphone.setText(rs.getString("phone"));

            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBounds(40,350,150,30);
        checkPrice.addActionListener(this);
        add(checkPrice);
        
        
        bookPackage = new JButton("Book Package");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBounds(210,350,150,30);
        bookPackage.addActionListener(this);
        add(bookPackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(150,400,100,30);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i6 = i5.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        
        JLabel image2 = new JLabel(i7);
        image2.setBounds(400,40,460,300);
        add(image2);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkPrice){
            int n = Integer.parseInt(labelperson.getText());
            int cost=0;
            String pack = ch.getSelectedItem();
            if(pack.equals("Gold Package")){
                cost+=12999;
            }else if(pack.equals("Silver Package")){
                cost+=9999;
            }else{
                cost+= 7999;
            }
            cost*= n;
            labelprice.setText("Rs " + cost);
        }else if(ae.getSource()==bookPackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookedPackage values('"+username+"', '"+ch.getSelectedItem()+"', '"+labelperson.getText()+"', '"+labelid.getText()+"', '"+labelIDnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package booked successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
         }else{
            setVisible(false);
        }
    }
    
    
    public static void main(String args[]){
        new BookPackage("");
    }
}
