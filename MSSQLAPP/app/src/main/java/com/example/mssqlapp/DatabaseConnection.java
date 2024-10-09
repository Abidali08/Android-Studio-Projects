package com.example.mssqlapp;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseConnection {

    // Define JDBC connection parameters
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=HR";
    private static final String USER = "as";
    private static final String PASSWORD = "1234";

    // Method to connect and fetch data from MSSQL using ExecutorService
    public void fetchData() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null;

                try {
                    // Establish the connection
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);

                    // Create a statement
                    statement = connection.createStatement();

                    // Execute a query
                    String sql = "SELECT * FROM regions";
                    resultSet = statement.executeQuery(sql);

                    // Process the results
                    while (resultSet.next()) {
                        String data1 = resultSet.getString("region_id");  // Get column data
                        String data2 = resultSet.getString("region_name");  // Get column data
                        Log.d("Region Data: ", "Region ID: " + data1 + " Region Name: " + data2);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // Close the connections
                    try {
                        if (resultSet != null) resultSet.close();
                        if (statement != null) statement.close();
                        if (connection != null) connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
