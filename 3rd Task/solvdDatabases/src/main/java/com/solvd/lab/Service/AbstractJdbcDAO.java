package com.solvd.lab.Service;

import com.solvd.lab.connections.ConnectionPool;

public class AbstractJdbcDAO {

    private static ConnectionPool cp = ConnectionPool.getInstance();

    public AbstractJdbcDAO() {
        cp = ConnectionPool.getInstance();
    }

    public ConnectionPool getConnectionPool() {
        return cp;
    }
}
