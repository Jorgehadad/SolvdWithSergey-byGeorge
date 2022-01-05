package com.solvd.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.jar.Attributes.Name;

import com.solvd.jdbc.connections.PoolConnection;
import com.solvd.jdbc.entities.Area;
import com.solvd.jdbc.interfaces.IAreasDAO;

public class AreasService extends AbstractJdbcDAO implements IAreasDAO {

    private final static String SQL_INSERT =    "INSERT INTO Area(NameA, NameP, Extension) VALUES(?, ?, ?)";
    private final static String SQL_UPDATE =    "UPDATE Area SET NameA=?, NameP=?, Extension=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Area WHERE NameA = ?";
    private final static String SQL_DELETE =    "DELETE FROM Area WHERE NameA = ?";

    public void AreasDAO(){}

    @Override
    public void save(Area area) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, area.getNameA());
            ps.setString(2, area.getNameP());
            ps.setDouble(3, area.getExtencion());
            System.out.println("Query been executed " + SQL_INSERT);
            ps.executeUpdate();
        } finally{
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    @Override
    public void update(Area area) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, area.getNameA());
            ps.setString(2, area.getNameP());
            ps.setDouble(3, area.getExtencion());

            System.out.println("Query been executed " + SQL_UPDATE);
            ps.executeUpdate();
            System.out.println("The area "+ area.toString() + " has been updated");
        } finally{
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    @Override
    public void delete(Area area) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            System.out.println("Query been executed " + SQL_DELETE);

            ps.setNString(1, area.getNameA());
            ps.executeUpdate();
            System.out.println(area.toString() + " deleted");
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    public Area getByNameA(String NameA) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Area area = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            ps.setNString(1, NameA);
            rs = ps.executeQuery();
            while(rs.next()){
                area = new Area();
                area.setNameA(rs.getString("NameA"));
                area.setNameP(rs.getString("NameP"));
                area.setExtencion(rs.getDouble("Extencion"));
            }
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
            if(rs != null)
                rs.close();
        }
        return area;
    }
}
