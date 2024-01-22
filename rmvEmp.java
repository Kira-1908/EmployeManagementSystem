package EmployeManag;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class rmvEmp extends JFrame implements ActionListener{

    Choice cEmp;
    JButton delete, back;

    rmvEmp(){
        setSize(1000,550);
        setLocation(300, 150);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblempId = new JLabel("Employee ID");
        lblempId.setBounds(50,50,100,30);
        add(lblempId);

        cEmp = new Choice();
        cEmp.setBounds(154, 53, 140, 30);
        add(cEmp);

        try {
            dbConn c = new dbConn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                cEmp.add(rs.getString("empID"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(154,100,100,30);
        add(lblname);

        JLabel labelphn = new JLabel("Phone");
        labelphn.setBounds(50,150,100,30);
        add(labelphn);

        JLabel lblphn = new JLabel();
        lblphn.setBounds(154,150,100,30);
        add(lblphn);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);

        JLabel lbleml = new JLabel();
        lbleml.setBounds(154,200,100,30);
        add(lbleml);

        try {
            dbConn c = new dbConn();
            String query = "select * from employee where empID = '"+cEmp.getSelectedItem()+"' ";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                lblname.setText(rs.getString("empName"));
                lblphn.setText(rs.getString("phn"));
                lbleml.setText(rs.getString("email"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

       cEmp.addItemListener(new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent ie) {

               try {
                   dbConn c = new dbConn();
                   String query = "select * from employee where empID = '"+cEmp.getSelectedItem()+"' ";
                   ResultSet rs = c.s.executeQuery(query);

                   while(rs.next()){
                       lblname.setText(rs.getString("empName"));
                       lblphn.setText(rs.getString("phn"));
                       lbleml.setText(rs.getString("email"));

                   }

               }catch (Exception e){
                   e.printStackTrace();
               }
           }
       });

        delete = new JButton("Delete");
        delete.setBounds(80,300, 100, 30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("ImagesEMP/delete.png"));
        Image i4 = img4.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon im4 = new ImageIcon(i4);
        JLabel image4 = new JLabel(im4);
        image4.setBounds(370,0,600,400);
        add(image4);

    }


    public void actionPerformed (ActionEvent ae){

        if(ae.getSource() == delete){

            try {
               dbConn c = new dbConn();
               String query =  "delete from employee where empID = '"+cEmp.getSelectedItem()+"' ";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Employee information removed");
               setVisible(false);
               new Home();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else {
            setVisible(false);
            new Home();
        }

    }



}
