/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;

import java.awt.*;
import javax.swing.*;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements Runnable {
    Thread thread;
    Splash() {
//        setSize(1200, 600); // making the size of frame
//        setLocationRelativeTo(null); // centralize the fram
        // accessing image. from i1, we can get any image from the folder icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        // accssing the image from i1
        JLabel image = new JLabel(i3);
        add(image);
        
        setVisible(true);
        thread = new Thread(this);
        thread.start();
        
    }
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
        }catch(Exception e){
            
        }
    }

    // ✅ Main method (Java entry point)
    public static void main(String[] args) {
        Splash frame = new Splash();
        int x=0;
        for(int i=1; i<=500; x+=7, i+=6){
            frame.setLocation(750-(x+i)/2, 400-i/2);
            frame.setSize(x+i, i);
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
       
    }
}
