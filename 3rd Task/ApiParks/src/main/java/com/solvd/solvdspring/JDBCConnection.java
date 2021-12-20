package com.solvd.solvdspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

    public static void main(String[] args) {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/solvdspring", "Admin", "Admin");
        Statement statement = connection.createStatement();
        boolean res = statement.execute("select * from parks");
        System.out.println(res);
        if (res) {
            ResultSet resultSet = statement.getResultSet();
        }
    }


    




    
}
