package com.solvd.jdbc.connections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main{
    int POOL_SIZE = 5;
    private final static Integer EXEC = 6;
    private static int count = 1;
    private final static ConnectionPool cp = ConnectionPool.getInstance();


    public static void main(String[] args) {
        ExecutorService connectionsExecutor = Executors.newFixedThreadPool(EXEC);

        IntStream
                .range(0,EXEC)
                .forEach(e -> {
                                        connectionsExecutor.execute(new RunnableConnection(count, cp));
                                        count++;
                });
        count = 1;
    }
}