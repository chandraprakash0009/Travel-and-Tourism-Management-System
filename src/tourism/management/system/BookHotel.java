
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

public class BookHotel extends JFrame implements ActionListener{
    String username;
    JLabel labelprice, labelid, labelidnumber, labelphone;
    JButton checkPrice, back, book;
    JTextField labelperson, labeldays;
    Choice labelhotel, labelroomtype, labelfood;
    BookHotel(String username){
        this.username=username;
        
        setBounds(200,200,1000,600);
        setLayout(null);
        setBackground(Color.white);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(500,20,400,400);
        add(l1);
        
        
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(70,20,150,30);
        add(lblusername);
        
        JLabel lblselecthotel = new JLabel("Select Hotel");
        lblselecthotel.setBounds(70,60,150,30);
        add(lblselecthotel);
        
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(70,100,150,30);
        add(lblperson);
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(70,140,150,30);
        add(lbldays);
        
        JLabel lbltype = new JLabel("AC/Non-AC");
        lbltype.setBounds(70,180,150,30);
        add(lbltype);
        
        JLabel lblfood = new JLabel("Food included");
        lblfood.setBounds(70,220,150,30);
        add(lblfood);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(70,260,150,30);
        add(lblid);
        
        JLabel lblidnumber = new JLabel("ID Number");
        lblidnumber.setBounds(70,300,150,30);
        add(lblidnumber);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(70,340,150,30);
        add(lblphone);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(70,380,150,30);
        add(lblprice);
        
        // adding detail
        
        JLabel labelusername = new JLabel(username);
        labelusername.setBounds(300,20, 150, 30);
        add(labelusername);
        
        
        // for hotel selection
        labelhotel = new Choice();
        labelhotel.setBounds(300,60, 150, 30);
        add(labelhotel);
        
        
        labelperson = new JTextField();
        labelperson.setBounds(300,100, 150, 30);
        labelperson.setBorder(BorderFactory.createLineBorder(Color.black));
        add(labelperson);
        
        labeldays = new JTextField();
        labeldays.setBounds(300,140, 150, 30);
        labeldays.setBorder(BorderFactory.createLineBorder(Color.black));
        add(labeldays);
        
        // for room_type
        labelroomtype = new Choice();
        labelroomtype.add("AC");
        labelroomtype.add("Non-AC");
        labelroomtype.setBounds(300,180, 150, 30);
        add(labelroomtype);
   
        // for food
        labelfood = new Choice();
        labelfood.add("YES");
        labelfood.add("NO");
        labelfood.setBounds(300,220, 150, 30);
        add(labelfood);
        
        
        labelid = new JLabel();
        labelid.setBounds(300,260, 150, 30);
        add(labelid);
        
        labelidnumber = new JLabel();
        labelidnumber.setBounds(300,300, 150, 30);
        add(labelidnumber);
        
        labelphone = new JLabel();
        labelphone.setBounds(300,340, 150, 30);
        add(labelphone);
        
        labelprice = new JLabel();
        labelprice.setBounds(300,380, 150, 30);
        labelprice.setBorder(BorderFactory.createLineBorder(Color.blue));
        add(labelprice);
        
        
        try{
            Conn c = new Conn();
            
            String s= "select * from hotel";
            ResultSet rs = c.s.executeQuery(s);
            while(rs.next()){
                labelhotel.add(rs.getString("hotelName"));
            }
            
            s = "select * from customer where username = '"+username+"'";
            rs = c.s.executeQuery(s);
            while(rs.next()){
                labelid.setText(rs.getString("userID"));
                labelidnumber.setText(rs.getString("IDnumber"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            System.out.print(e);
        }
        
        
        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.blue);
        checkPrice.setForeground(Color.white);
        checkPrice.setBounds(50,430,120,30);
        checkPrice.addActionListener(this);
        add(checkPrice);
        
        
        book = new JButton("Book");
        book.setBackground(Color.blue);
        book.setForeground(Color.white);
        book.setBounds(200,430,100,30);
        book.addActionListener(this);
        add(book);
        
        
        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.setBounds(330,430,100,30);
        back.addActionListener(this);
        add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            return;
        }
        String selectedHotel = labelhotel.getSelectedItem();
        int noPerson = Integer.parseInt(labelperson.getText());
        int noDays = Integer.parseInt(labeldays.getText());
        String room = labelroomtype.getSelectedItem();
        boolean acRoom = (room.equals("AC"))? true : false;
        String food = labelfood.getSelectedItem();
        boolean foodIncluded = (food.equals("YES")) ? true : false;        
        
        if(ae.getSource()==checkPrice){ 
            if(noPerson * noDays > 0){
                try{
                    Conn c = new Conn();
                    String query = "select * from hotel where hotelName = '"+selectedHotel+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    int costPerPerson=0, ACcharge=0, foodCharge=0;
                    while(rs.next()){
                        costPerPerson = Integer.parseInt(rs.getString("costPerPerson"));
                        ACcharge = Integer.parseInt(rs.getString("ACcharge"));
                        foodCharge = Integer.parseInt(rs.getString("foodCharge"));
                    }
                    int cost = costPerPerson;
                    if(acRoom) cost+= ACcharge;
                    if(foodIncluded) cost+= foodCharge;
                    
                    cost = cost*noPerson;
                    cost = cost*noDays;
                    labelprice.setText("RS. " + cost);
                }catch(Exception e){
                    System.out.print(e);
                }
            }
        }else{
            try{
                Conn c = new Conn();
                String query = "insert into bookedHotel values('"+username+"', '"+labelid.getText()+"', '"+labelidnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"', '"+selectedHotel+"', '"+noPerson+"', '"+noDays+"', '"+room+"', '"+food+"' )";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Hotel booked successfully");
                setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            } 
        }
    }
    
    public static void main(String args[]){
        new BookHotel("");
    }
}
