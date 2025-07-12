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

public class CheckDestination extends JFrame implements Runnable{
    JLabel label[];
    Thread t1;
    JLabel caption;
    String hotelName[];
    
    public void run(){
        
        try{
            for(int i=0; i<10; i++){
                label[i].setVisible(true);
                caption.setText(hotelName[i]);
                Thread.sleep(1000);
                label[i].setVisible(false);
            }
           
        }catch(Exception e){
            System.out.print(e);
        }
    }
    
    
    CheckDestination(){
        setBounds(350,100,900,600);
        t1 = new Thread(this);
        
        ImageIcon nums1[]=new ImageIcon[10];
        Image nums2[]=new Image[10];
        ImageIcon nums3[] =new ImageIcon[10];
        
        label = new JLabel[10];
        
        hotelName = new String[]{"Dest_Name_1", "Dest_Name_2", "Dest_Name_3", "Dest_Name_4", "Dest_Name_5", "Dest_Name_6", "Dest_Name_7", "Dest_Name_8", "Dest_Name_9","Dest_Name_10"};
        caption=new JLabel();
        caption.setBounds(300,10,500,70);
        caption.setFont(new Font("TAHOMA", Font.BOLD, 40));
        caption.setForeground(Color.red);
        add(caption);
        
        // add destination photo
        
        for(int i=0; i<10; i++){
            nums1[i] = new ImageIcon(ClassLoader.getSystemResource("icons/hotel" + (i+1) + ".jpg"));
            nums2[i] = nums1[i].getImage().getScaledInstance(900,600, Image.SCALE_DEFAULT);
            nums3[i] = new ImageIcon(nums2[i]);
            
            label[i]=new JLabel(nums3[i]);
            label[i].setBounds(0,0,900,600);
            add(label[i]);
            
        }
        
        t1.start();
        setVisible(true);
    }
    
    public static void main(String args[]){
        new CheckDestination();
    }
}