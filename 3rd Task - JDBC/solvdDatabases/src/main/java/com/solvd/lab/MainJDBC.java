package com.solvd.lab;

import java.sql.Connection;
import java.sql.SQLException;

import com.solvd.lab.Service.AreasService;
import com.solvd.lab.connections.PoolConnection;
import com.solvd.lab.dao.Areas;

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

        Areas area = new Areas();
        area.setNameA("Area15");
        area.setNameP("With Summer");
        area.setExtencion(100.0);

        AreasService areasService = new AreasService();
        areasService.save(area);
        //areasService.getByNameA(area.getNameA());
        //areasService.update(area);
        //areasService.delete(area);


    }
}
