/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn  {
    Connection c;
    Statement s;
    Conn(){
        try{
            // step-1 register the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            // step-2 register connection string
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root", "Mahi@123");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
