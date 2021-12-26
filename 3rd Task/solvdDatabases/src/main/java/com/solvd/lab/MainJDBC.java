package com.solvd.lab;

import java.sql.Connection;
import java.sql.SQLException;

import com.solvd.lab.connections.PoolConnection;

public class MainJDBC {


    public static void main(String[] args) throws SQLException {


        Connection conn = null;
        try {
            conn = PoolConnection.getConnection();
            System.out.println(conn + "Connection successful");
        }
        catch(SQLException ex){
            System.out.println(conn + "Connection failed");
        }
    }
}
