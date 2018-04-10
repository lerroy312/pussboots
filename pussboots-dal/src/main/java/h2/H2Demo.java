/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package h2;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.h2.jdbcx.JdbcConnectionPool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by chunhong.pch on 17/12/24.
 */
public class H2Demo {
    private static AtomicLong         cnt        = new AtomicLong();
    private static JdbcConnectionPool cp         = JdbcConnectionPool
        .create("jdbc:h2:mem:pussboots_h2;MVCC=TRUE;LOB_TIMEOUT=100", "pussboots", "");
    //private static Connection         connection = null;
    private static byte[]             blob       = new byte[1000];

    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        //connection = DriverManager.getConnection("jdbc:h2:mem:pussboots_h2;MVCC=TRUE", "pussboots", "");
        init();
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    mock();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        cp.dispose();
        cp = null;
        Thread.sleep(100000000L);
    }

    private static void init() throws Exception {
        Connection connection = cp.getConnection();
        Statement statement = connection.createStatement();
        String createTable = readCreateTableSql();
        statement.execute(createTable);
        statement.close();
        connection.close();
        for (int i = 0; i < 1000; i++) {
            blob[i] = 1;
        }
    }

    private static String readCreateTableSql() throws Exception {
        InputStream inputStream = Class.class.getResourceAsStream("/h2/h2.sql");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String tmp = null;
        while ((tmp = bufferedReader.readLine()) != null) {
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }

    private static void mock() {
        while (true){
            try {
                Connection connection = cp.getConnection();
                //String insertTemplate = "insert into bp_instance(id,gmt_create,name) values(?,?,?);";
                String insertTemplate = "insert into bp_instance(id,gmt_create,name,property) values(?,?,?,?);";
                PreparedStatement preparedStatement = connection.prepareStatement(insertTemplate);
                String id = UUID.randomUUID().toString();
                preparedStatement.setString(1,id);
                preparedStatement.setDate(2,new Date(System.currentTimeMillis()));
                preparedStatement.setString(3,UUID.randomUUID().toString());
                preparedStatement.setBlob(4, new ByteInputStream(blob,1000));
                int result = preparedStatement.executeUpdate();
                preparedStatement.close();

                String queryTemplate = "select * from bp_instance where id = ?";
                preparedStatement = connection.prepareStatement(queryTemplate);
                preparedStatement.setString(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                preparedStatement.close();

                String deleteTemplate = "delete from bp_instance where id = ?";
                preparedStatement = connection.prepareStatement(deleteTemplate);
                preparedStatement.setString(1,id);
                int n = preparedStatement.executeUpdate();
                preparedStatement.close();

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}