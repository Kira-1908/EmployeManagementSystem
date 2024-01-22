package EmployeManag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{

    Splash(){

        getContentPane().setBackground(new Color(234,235,223));

        JLabel title = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        add(title);

        setLayout(null);
        title.setBounds(410,17,1900,29);
        title.setFont(new Font("Serif", Font.BOLD,40));
        title.setForeground(new Color(32,110,189));


        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("ImagesEMP/imgg1.jpg"));
        Image i1 = img1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon im1 = new ImageIcon(i1);
        JLabel image1 = new JLabel(im1);
        image1.setBounds(50,90,1400,680);
        add(image1);

        JButton click = new JButton("Click To Login");
        click.setBounds(390,609,280,50);
        click.setBackground(Color.white);
        click.setForeground(Color.black);
        click.setFont(new Font("Serif",Font.BOLD,22));
        click.addActionListener(this);
        image1.add(click);


        setSize(1220, 710);
        setVisible(true);
        setLocation(50,60);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new login();
    }
}
