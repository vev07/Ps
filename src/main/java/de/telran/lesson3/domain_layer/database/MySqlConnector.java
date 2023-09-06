package de.telran.lesson3.domain_layer.database;

import java.sql.Connection;
import java.sql.DriverManager;

import static de.telran.lesson3.constants.Constants.*;

public class MySqlConnector {
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_PATH);
            String dbUrl = String.format("%s%s?user=%s&password=%s",
                    DB_ADDRESS,DB_NAME,USER_NAME,DB_PASSWORD);
            return DriverManager.getConnection(dbUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
