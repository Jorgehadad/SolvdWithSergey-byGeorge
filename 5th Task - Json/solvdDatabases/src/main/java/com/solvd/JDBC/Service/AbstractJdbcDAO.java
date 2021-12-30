package com.solvd.JDBC.Service;

import com.solvd.JDBC.connections.ConnectionPool;

public class AbstractJdbcDAO {

    private static ConnectionPool cp = ConnectionPool.getInstance();

    public AbstractJdbcDAO() {
        cp = ConnectionPool.getInstance();
    }

    public ConnectionPool getConnectionPool() {
        return cp;
    }
}
