package com.solvd.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.solvd.jdbc.connections.PoolConnection;
import com.solvd.jdbc.dao.AreasService;
import com.solvd.jdbc.entities.Area;

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

        Area area = new Area();
        area.setNameA("Area19");
        area.setNameP("With Summer");
        area.setExtencion(100.0);

        AreasService areasService = new AreasService();
        areasService.save(area);
        //areasService.getByNameA(area.getNameA());
        //areasService.update(area);
        //areasService.delete(area);


    }
}
