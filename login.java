package EmployeManag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JTextField textName, passName;

    login(){

        setSize(430,299);
        setVisible(true);
        setLocation(400,150);

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel labelUsrName = new JLabel("User Name");
        labelUsrName.setBounds(32,9,350,69);
        add(labelUsrName);

        textName = new JTextField();
        textName.setBounds(32,54,90,20);
        add(textName);

        JLabel labelpassword = new JLabel("Password");
        labelpassword.setBounds(32,79,350,69);
        add(labelpassword);


        passName = new JTextField();
        passName.setBounds(32,125,90,20);
        add(passName);

        JButton logIn = new JButton("LOGIN");
        logIn.setBounds(32,174,100,23);
        logIn.setBackground(Color.black);
        logIn.setForeground(Color.white);
        logIn.setFont(new Font("Serif",Font.BOLD,15));
        logIn.addActionListener(this);
        add(logIn);

        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("ImagesEMP/img2.jpg"));
        Image i2 = img2.getImage().getScaledInstance(148, 136, Image.SCALE_DEFAULT);
        ImageIcon im2 = new ImageIcon(i2);
        JLabel image2 = new JLabel(im2);
        image2.setBounds(200,62,125,117);
        add(image2);

    }
    public void actionPerformed (ActionEvent ae){

        try{
            String username = textName.getText();
            String password = passName.getText();

            dbConn dc = new dbConn(); //making object of dbConn class to use 'executeQuery'

            String query = "select * from login where username = '"+username+"' and passcode = '"+password+"'";

            dc.s.executeQuery(query); //Used through (Statement s)

            ResultSet rs = dc.s.executeQuery(query);
            if (rs.next()){
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username and password");
                setVisible(true);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }



}
