package com.jhonatan.biblioteca.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //atributos
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_jhonatan?serverTimezone=UTC";
    private static final String USERAME = "root";
    private static final String PASSWORD = "1234";
    private static Connection connection;
    //patron singleton

    public static Connection getInstance() throws SQLException {
        //devolvemos una instancia de la conexion a la BD
        return DriverManager.getConnection(URL, USERAME, PASSWORD);
    }
}
