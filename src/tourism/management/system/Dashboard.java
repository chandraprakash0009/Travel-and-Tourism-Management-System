/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addPersonalDetail, viewPersonalDetail,updatePersonalDetail,checkPackage,bookpackage,viewPackage;
    JButton viewHotel,destinations, bookHotel, viewBookedHotel,payments,calculator,notepad,about,deletePersonalDetail;
    Dashboard(String usern){
        this.username = usern;
        // take whole screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        //make panel for heading
        JPanel p1= new  JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,1600,65);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        // add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,60,60);
        p1.add(icon);
        // add heading
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD,30 ));
        p1.add(heading);
        // make panel to add button
        JPanel p2= new  JPanel();
        p2.setLayout(null);
        p2.setBounds(0,65,300,900);
        p2.setBackground(new Color(0,0,102));
        add(p2);
        
        // add button
        addPersonalDetail = new JButton("Add Personal Detail");
        addPersonalDetail.setBounds(0,0,300,50 );
        addPersonalDetail.setBackground(new Color(0,0,102));
        addPersonalDetail.setForeground(Color.white);
        addPersonalDetail.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        addPersonalDetail.setMargin(new Insets(0,0,0,60)); //top-left-bottom-right
        addPersonalDetail.addActionListener(this);
        p2.add(addPersonalDetail);
        
        updatePersonalDetail = new JButton("Update Personal Detail");
        updatePersonalDetail.setBounds(0,50,300,50 );
        updatePersonalDetail.setBackground(new Color(0,0,102));
        updatePersonalDetail.setForeground(Color.white);
        updatePersonalDetail.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        updatePersonalDetail.setMargin(new Insets(0,0,0,30));
        updatePersonalDetail.addActionListener(this);
        p2.add(updatePersonalDetail);
        
        
        viewPersonalDetail = new JButton("View  Personal Detail");
        viewPersonalDetail.setBounds(0,100,300,50 );
        viewPersonalDetail.setBackground(new Color(0,0,102));
        viewPersonalDetail.setForeground(Color.white);
        viewPersonalDetail.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        viewPersonalDetail.setMargin(new Insets(0,0,0,40));
        viewPersonalDetail.addActionListener(this);
        p2.add(viewPersonalDetail);
        
        
        deletePersonalDetail = new JButton("Delete  Personal Detail");
        deletePersonalDetail.setBounds(0,150,300,50 );
        deletePersonalDetail.setBackground(new Color(0,0,102));
        deletePersonalDetail.setForeground(Color.white);
        deletePersonalDetail.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        deletePersonalDetail.setMargin(new Insets(0,0,0,30));
        deletePersonalDetail.addActionListener(this);
        p2.add(deletePersonalDetail);
        
        
        checkPackage = new JButton("Check Package");
        checkPackage.setBounds(0,200,300,50 );
        checkPackage.setBackground(new Color(0,0,102));
        checkPackage.setForeground(Color.white);
        checkPackage.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        checkPackage.setMargin(new Insets(0,0,0,30));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0,250,300,50 );
        bookpackage.setBackground(new Color(0,0,102));
        bookpackage.setForeground(Color.white);
        bookpackage.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        bookpackage.setMargin(new Insets(0,0,0,30));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);
        
        
        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0,300,300,50 );
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.white);
        viewPackage.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        viewPackage.setMargin(new Insets(0,0,0,30));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);
        
        viewHotel = new JButton("View Hotel");
        viewHotel.setBounds(0,350,300,50 );
        viewHotel.setBackground(new Color(0,0,102));
        viewHotel.setForeground(Color.white);
        viewHotel.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        viewHotel.addActionListener(this);
        viewHotel.setMargin(new Insets(0,0,0,30));
        p2.add(viewHotel);
        
        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0,400,300,50 );
        bookHotel.setBackground(new Color(0,0,102));
        bookHotel.setForeground(Color.white);
        bookHotel.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        bookHotel.setMargin(new Insets(0,0,0,30));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);
        
        
        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0,450,300,50 );
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        viewBookedHotel.setMargin(new Insets(0,0,0,30));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);
        
        destinations = new JButton("Destiantions");
        destinations.setBounds(0,500,300,50 );
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        destinations.setMargin(new Insets(0,0,0,30));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payments = new JButton("Payments");
        payments.setBounds(0,550,300,50 );
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        payments.setMargin(new Insets(0,0,0,30));
        payments.addActionListener(this);
        p2.add(payments);
        
        calculator = new JButton("Calculator");
        calculator.setBounds(0,600,300,50 );
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        calculator.setMargin(new Insets(0,0,0,30));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        notepad = new JButton("Notepad");
        notepad.setBounds(0,650,300,50 );
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        notepad.setMargin(new Insets(0,0,0,30));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about = new JButton("About");
        about.setBounds(0,700,300,50 );
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
        about.setMargin(new Insets(0,0,0,30));
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        //ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setForeground(Color.white);
        text.setBounds(500,100,900,60);
        text.setFont(new Font("SAN_SERIF", Font.BOLD, 45));
        image.add(text);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== addPersonalDetail){
            new AddCustomer(username);
        }else if(ae.getSource() == viewPersonalDetail){
            new ViewCustomer(username);
        }else if(ae.getSource()==updatePersonalDetail){
            new UpdateDetail(username);
        }else if(ae.getSource()==checkPackage){
            new CheckPackage();
        }else if(ae.getSource()==bookpackage){
            new BookPackage(username);
        }else if(ae.getSource()==viewPackage){
            new ViewPackage(username);
        }else if(ae.getSource()==viewHotel){
            new CheckHotels();
        }else if(ae.getSource()==destinations){
            new CheckDestination();
        }else if(ae.getSource()==bookHotel){
            new BookHotel(username);
        }else if(ae.getSource()==viewBookedHotel){
            new ViewBookedHotel(username);
        }else if(ae.getSource()==payments){
            new Payment();
        }else if(ae.getSource()==calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                System.out.print(e);
            } 
        }else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                System.out.print(e);
            } 
        }else if(ae.getSource()==about){
            new About();
        }else if(ae.getSource()==deletePersonalDetail){
            new DeletePersonalDetail(username);
        }
    }
    
    public static void main(String args[]){
        new Dashboard("");
    }
}
