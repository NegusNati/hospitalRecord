package com.example.hospitalrecord.controllers;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Jdbc {
    Alert a;
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "Admin";
    private static final String password = "admin123";

    public Connection connMethod() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {
           a = new Alert(Alert.AlertType.INFORMATION);
           a.setContentText(" DATA-BASE COULDN'T BE REACHED!  ");
        }
        return con;
    }
}
