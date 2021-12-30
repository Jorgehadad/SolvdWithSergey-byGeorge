package com.solvd.JDBC.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.solvd.JDBC.dao.Parks;

public abstract class ParksService {
    private Connection connection;

    public abstract List<Parks> getParks();

    public abstract void addPark(Parks park);

    public abstract void deletePark(Parks park);

    public abstract void updatePark(Parks park);

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
