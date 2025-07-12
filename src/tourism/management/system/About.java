package tourism.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener{
    JButton back;
    About(){
        setBounds(300,50,800,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel lbl = new JLabel("About");
        lbl.setBounds(300,20,150,30);
        lbl.setForeground(Color.red);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lbl);
        
        String s="huuihuihuihuhhhjiojiojiojoijoijijoijijoijijiojoijojojoojoijuihugytrtrrtdygugyugyu";
        
        TextArea area=new TextArea(s, 10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(50,100,700,350);
        add(area);
        
        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.setBounds(300,500,100,30);
        back.addActionListener(this);
        add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        
    }
    public static void main(String args[]){
        new About();
    }
}
