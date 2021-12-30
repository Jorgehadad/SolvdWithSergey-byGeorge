package com.solvd.JDBC.connections;

public class ThreadConnection {
    private int threadId;
    private ConnectionPool cp;

    public ThreadConnection() {}

    public ThreadConnection(int threadId, ConnectionPool pool) {
        this.threadId = threadId;
        this.cp = pool;
    }

    public void run() {
        Connection connection = null;
        try {
            connection = cp.getConnection();
        } catch (InterruptedException exception) {
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
        }

        cp.add(connection);
    }
}
