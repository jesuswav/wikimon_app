package com.example.wikimon_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionBBDD {

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemones",
                    "root", "");

        }catch (SQLException e){
            System.out.println("Failed connection");
            System.out.println(e);
        }

        return connection;
    }

}
