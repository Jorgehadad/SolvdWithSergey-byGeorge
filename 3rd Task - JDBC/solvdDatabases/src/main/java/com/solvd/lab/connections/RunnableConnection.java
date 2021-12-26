package com.solvd.lab.connections;

public class RunnableConnection implements Runnable{
    private final ConnectionPool cp;
    private final int id;

    public RunnableConnection(int id, ConnectionPool cp){
        this.id = id;
        this.cp = cp;
    }

    public void run(){
        Connection conn = null;

        try {
            conn = cp.getConnection();

            conn.doSomething();

            cp.backConnection(conn);

        } catch (InterruptedException e) {
        }
    }

    public int getId() {
        return id;
    }

    public ConnectionPool getCp() {
        return cp;
    }

    @Override
    public String toString(){
        return "RunnableConnection " + id;
    }
}
