package com.example.carapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private static DbHelper INSTANCE;
    public static DbHelper getInstance(){
        if(INSTANCE == null)
            INSTANCE =new DbHelper();
        return INSTANCE;
    }
    public void connect(){
        Connection connection = null;
        String url = "jdbc:sqlite:C:/Users/MSI/Documents/db/cardb.db";
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("connection");

        } catch (SQLException e) {
            System.out.println("error");
            throw new RuntimeException(e);
        }

    }



}
