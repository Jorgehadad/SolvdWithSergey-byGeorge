package com.solvd.jdbc.Service;

import com.solvd.jdbc.connections.ConnectionPool;

public class AbstractJdbcDAO {

    private static ConnectionPool cp = ConnectionPool.getInstance();

    public AbstractJdbcDAO() {
        cp = ConnectionPool.getInstance();
    }

    public ConnectionPool getConnectionPool() {
        return cp;
    }
}
