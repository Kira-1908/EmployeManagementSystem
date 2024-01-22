package EmployeManag;

import java.sql.*;

public class dbConn {

    Connection c;
    Statement s;

    dbConn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/empManagement","root","theasura321");
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
