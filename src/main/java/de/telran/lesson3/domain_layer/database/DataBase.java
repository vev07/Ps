package de.telran.lesson3.domain_layer.database;

import java.sql.SQLException;
import java.util.List;

public interface DataBase {

    void execute(String query) throws SQLException;

    List<Object> select(String query) throws SQLException;
}