package EmployeManag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton addEmp, viewEmp, updateEmp, removeEmp;
    Home(){
        setLayout(null);

        ImageIcon img3 = new ImageIcon(ClassLoader.getSystemResource("ImagesEMP/img3.jpg"));
        Image i3 = img3.getImage().getScaledInstance(1024, 576, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(i3);
        JLabel image3 = new JLabel(im3);
        image3.setBounds(0,0,1024,576);
        add(image3);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(300,12,400,32);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 23));
        image3.add(heading);

        addEmp = new JButton("Add Employees");
        addEmp.setBounds(325, 64, 143, 45);
        addEmp.addActionListener(this);
        image3.add(addEmp);

        viewEmp = new JButton("View Employees");
        viewEmp.setBounds(495, 64, 143, 45);
        viewEmp.addActionListener(this);
        image3.add(viewEmp);

        updateEmp = new JButton("Update Employees");
        updateEmp.setBounds(325, 129, 143, 45);
        updateEmp.addActionListener(this);
        image3.add(updateEmp);

        removeEmp = new JButton("Remove Employees");
        removeEmp.setBounds(495, 129, 143, 45);
        removeEmp.addActionListener(this);
        image3.add(removeEmp);

        setSize(1024, 576);
        setVisible(true);
        setLocation(250,100);
    }


    public void actionPerformed (ActionEvent ae){
        
        if(ae.getSource() == addEmp){
            setVisible(false);
            new addEMp();
            
        }else if (ae.getSource() == viewEmp){
            setVisible(false);
            new viewEmp();
            
        }else if (ae.getSource() == updateEmp){
            setVisible(false);
            new viewEmp();
            
        } else {
            setVisible(false);
            new rmvEmp();
        }
    }



}
