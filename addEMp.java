package EmployeManag;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.*;

public class addEMp extends JFrame implements ActionListener {

    Random ID = new Random();
    int num = ID.nextInt(90000);

    JTextField empName, tfName, tfsalary, tfaddress, tfphn, tfemail, tadhaar, tfempID;

    JButton addetails, back;
    JDateChooser dcdob;
    JComboBox educ;
    JLabel lblempID;

    addEMp(){

        setSize(1010,795);
        setLocation(250, 50);
        setVisible(true);

        getContentPane().setBackground(new Color(234, 235, 223));
        setLayout(null);

        JLabel title = new JLabel("ADD EMPLOYEE DETAILS");
        title.setBounds(292, 13,385,39);
        title.setFont(new Font("TAHOMA", Font.BOLD, 29));
        add(title);

        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(50, 150, 200, 32);
        lblname.setFont(new Font("serif", Font.PLAIN, 25));
        add(lblname);

        empName = new JTextField();
        empName.setBounds(147,153,158,30);
        add(empName);

        JLabel fname = new JLabel("Father's Name :");
        fname.setBounds(50, 260, 200, 32);
        fname.setFont(new Font("serif", Font.PLAIN, 25));
        add(fname);

        tfName = new JTextField();
        tfName.setBounds(227,263,158,30);
        add(tfName);

        JLabel DOB = new JLabel("Date Of Birth");
        DOB.setBounds(470, 150, 200, 32);
        DOB.setFont(new Font("serif", Font.PLAIN, 25));
        add(DOB);

        dcdob = new JDateChooser();
        dcdob.setBounds(627,150,145,32);
        add(dcdob);

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

        String course [] = {"PhD", "MTech", "BTech", "MSc", "BSc", "MBA", "MCA", "BCA"};
        educ = new JComboBox(course);
        educ.setBounds(613,465,158,30);
        educ.setBackground(Color.white);
        add(educ);

        JLabel lbladhaar = new JLabel("Adhaar no :");
        lbladhaar.setBounds(50, 563, 200, 32);
        lbladhaar.setFont(new Font("serif", Font.PLAIN, 25));
        add(lbladhaar);

        tadhaar = new JTextField();
        tadhaar.setBounds(180,565,158,30);
        add(tadhaar);

        lblempID = new JLabel("Employee ID :");
        lblempID.setBounds(474, 563, 200, 32);
        lblempID.setFont(new Font("serif", Font.PLAIN, 25));
        add(lblempID);

        tfempID = new JTextField("" + num);
        tfempID.setBounds(645,565,158,30);
        add(tfempID);

        addetails = new JButton("Add Details");
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

        if(ae.getSource() == addetails){

            String empname = empName.getText();
            String fname = tfName.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phn = tfphn.getText();
            String email = tfemail.getText();
            String adhaar = tadhaar.getText();
            String empID = tfempID.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String education = (String)educ.getSelectedItem();

            try {
                dbConn conn = new dbConn();
                String query = "insert into employee values ('"+empname+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phn+"', '"+email+"', '"+adhaar+"', '"+empID+"', '"+education+"')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details saved successfully");
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
