/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;

import java.awt.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class CheckPackage extends JFrame {
    
    CheckPackage(){
        setBounds(400,100,800,700);
        getContentPane().setBackground(Color.white);
        JTabbedPane tab = new JTabbedPane();
        
        // provide utility as per your package
        String arr1[]= {"Gold Package", "7 days and 7 night stay", "Airport Assistance", "Daily biffet", "3 days city tour", "xyz...", "12,999"};
        String arr2[]= {"Silver Package", "7 days and 7 night stay", "Airport Assistance", "Daily biffet", "3 days city tour","xyz...","9,999"};
        String arr3[]= {"Bronze Package", "7 days and 7 night stay", "Airport Assistance", "Daily biffet", "3 days city tour","xyz...","7,99"};
        
        //JPanel p1 = createPackage(arr1);
        tab.addTab("Gold", createPackage(arr1));
        
        //JPanel p2 = createPackage(arr2);
        tab.addTab("Silver", createPackage(arr2));
        
        //JPanel p3 = createPackage(arr3);
        tab.addTab("Bronze", createPackage(arr3));
        
        add(tab);
        setVisible(true);
    }
    
    public JPanel createPackage(String arr[]){
        // first panel for gold
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        
        String s = arr[0];
        JLabel h1 = new JLabel(s);
        h1.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        h1.setForeground(Color.red);
        h1.setBounds(250,30,300,30);
        p1.add(h1);
        int w=80;
        for(int i=1; i<arr.length-1; i++){
            JLabel h2 = new JLabel(arr[i]);
            h2.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
            h2.setForeground(Color.blue);
            h2.setBounds(20,w,250,30);
            w+=50;
            p1.add(h2);
        }
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/special offer.jpg"));
        Image i6 = i5.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        
        JLabel image2 = new JLabel(i7);
        image2.setBounds(150,500,150,70);
        p1.add(image2);
        
        
        JLabel h10 = new JLabel("BOOK NOW IN JUST Rs. " + arr[arr.length-1] + "/- ONLY");
        h10.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        h10.setForeground(Color.red);
        h10.setBounds(300,525,500,30);
        p1.add(h10);
        
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/package1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,80,400,400);
        p1.add(image);
        return p1;
    }
    
    
    public static void main(String args[]){
        new CheckPackage();
    }
}
