package EmployeManag;


import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class updEmp extends JFrame implements ActionListener {

    //Random ID = new Random();
    //int num = ID.nextInt(90000);

    JTextField educ, tfName, tfsalary, tfaddress, tfphn, tfemail, tadhaar, tfempID;

    JButton addetails, back;

    //JDateChooser dcdob;
    //JComboBox educ;
    JLabel lblempID, lblupName, lbfName, lbldob,  lbadhaar;
    String empID;

    updEmp(String empID){
        this.empID = empID;

        setSize(1010,795);
        setLocation(250, 50);
        setVisible(true);

        getContentPane().setBackground(new Color(234, 235, 223));
        setLayout(null);

        JLabel title = new JLabel("UPDATE EMPLOYEE DETAILS");
        title.setBounds(292, 13,380,39);
        title.setFont(new Font("TAHOMA", Font.BOLD, 23));
        add(title);

        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(50, 150, 200, 32);
        lblname.setFont(new Font("serif", Font.PLAIN, 25));
        add(lblname);

        lblupName = new JLabel();
        lblupName.setBounds(147,153,158,30);
        add(lblupName);

        JLabel fname = new JLabel("Father's Name :");
        fname.setBounds(50, 260, 200, 32);
        fname.setFont(new Font("serif", Font.PLAIN, 25));
        add(fname);

        lbfName = new JLabel();
        lbfName.setBounds(227,263,158,30);
        add(lbfName);

        JLabel DOB = new JLabel("Date Of Birth");
        DOB.setBounds(470, 150, 200, 32);
        DOB.setFont(new Font("serif", Font.PLAIN, 25));
        add(DOB);

        lbldob = new JLabel();
        lbldob.setBounds(627,150,145,32);
        add(lbldob);

        JLabel lblsalary = new JLabel("Salary :");
        lblsalary.setBounds(474, 260, 200, 32);
        lblsalary.setFont(new Font("serif", Font.PLAIN, 25));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(585,263,158,30);
        add(tfsalary);

        JLabel lbladdress = new JLabel("Address :");
        lbladdress.setBounds(50, 363, 200, 32);
        lbladdress.setFont(new Font("serif", Font.PLAIN, 25));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(166,365,158,30);
        add(tfaddress);

        JLabel lblphn = new JLabel("Phone no. :");
        lblphn.setBounds(474, 363, 200, 32);
        lblphn.setFont(new Font("serif", Font.PLAIN, 25));
        add(lblphn);

        tfphn = new JTextField();
        tfphn.setBounds(613,365,158,30);
        add(tfphn);

        JLabel lblemail = new JLabel("Email ID :");
        lblemail.setBounds(50, 465, 200, 32);
        lblemail.setFont(new Font("serif", Font.PLAIN, 25));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(180,465,158,30);
        add(tfemail);

        JLabel lbleducation = new JLabel("Education :");
        lbleducation.setBounds(474, 463, 200, 32);
        lbleducation.setFont(new Font("serif", Font.PLAIN, 25));
        add(lbleducation);


        educ = new JTextField();
        educ.setBounds(613,465,158,30);
        add(educ);

        JLabel lbladhaar = new JLabel("Adhaar no :");
        lbladhaar.setBounds(50, 563, 200, 32);
        lbladhaar.setFont(new Font("serif", Font.PLAIN, 25));
        add(lbladhaar);

        lbadhaar = new JLabel();
        lbadhaar.setBounds(180,565,158,30);
        add(lbadhaar);

        lblempID = new JLabel("Employee ID :");
        lblempID.setBounds(474, 563, 200, 32);
        lblempID.setFont(new Font("serif", Font.PLAIN, 25));
        add(lblempID);

        tfempID = new JTextField();
        tfempID.setBounds(645,565,158,30);
        add(tfempID);

        try {
            dbConn c = new dbConn();
            String query = "select * from employee where empID = '"+empID+"' ";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){

                lblupName.setText(rs.getString("empName"));
                lbfName.setText(rs.getString("tfName"));
                lbldob.setText(rs.getString("DOB"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphn.setText(rs.getString("phn"));
                tfemail.setText(rs.getString("email"));
                lbadhaar.setText(rs.getString("adhaar"));
                tfempID.setText(rs.getString("empID"));
                educ.setText(rs.getString("education"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        addetails = new JButton("Update Details");
        addetails.setBounds(200, 650, 200, 45);
        addetails.setFont(new Font("TAHOMA", Font.BOLD,17));
        addetails.addActionListener(this);
        add(addetails);

        back = new JButton("Back");
        back.setBounds(500, 650, 200, 45);
        back.setFont(new Font("TAHOMA", Font.BOLD,17));
        back.addActionListener(this);
        add(back);


    }


    public void actionPerformed (ActionEvent ae) {

        if(ae.getSource() == addetails) {


            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phn = tfphn.getText();
            String email = tfemail.getText();
            String educt = educ.getText();

            try {
              dbConn conn = new dbConn();
              String query = "update employee set salary = '"+salary+"', address = '"+address+"', phn = '"+phn+"', email = '"+email+"',  education = '"+educt+"' where empID = '"+empID+"' ";

            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details updated successfully");
            setVisible(false);
            new Home();

            }catch (Exception e){
              e.printStackTrace();
            }

            }else {
              setVisible(false);
            new Home();
            }

        }

}
