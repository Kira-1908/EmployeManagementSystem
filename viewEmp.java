package EmployeManag;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.sql.*;
 import net.proteanit.sql.DbUtils;


public class viewEmp extends JFrame implements ActionListener {

    JTable table;
    Choice empID;
    JLabel searchlbl;

    JButton search, print, update, back;

    viewEmp(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        table = new JTable();

        JScrollPane sb = new JScrollPane(table);
        sb.setBounds(0, 120, 900, 700);
        add(sb);

        empID = new Choice();
        empID.setBounds(197, 20, 150, 20);
        add(empID);

        searchlbl = new JLabel("Search by Employee ID");
        searchlbl.setBounds(24, 20, 155, 20);
        searchlbl.setFont(new Font("TAHOMA", Font.BOLD, 12));
        searchlbl.setVisible(true);
        add(searchlbl);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);


        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);


        try {
            dbConn c = new dbConn();
            ResultSet rs = c.s.executeQuery("select * from employee");

            while (rs.next()){
                empID.add(rs.getString("empID"));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }


        try {
            dbConn c = new dbConn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void actionPerformed (ActionEvent ae){

        if(ae.getSource() == search){
            String query = "select * from employee where empID = '"+empID.getSelectedItem()+"'";

            try {
                dbConn c = new dbConn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == print) {

            try {
                table.print();
            } catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource() == update){
            setVisible(false);
            new updEmp(empID.getSelectedItem());

        }else {
            setVisible(false);
            new Home();
        }

    }
    //public static void main(String [] args){

      //  new viewEmp();
   // }




}
