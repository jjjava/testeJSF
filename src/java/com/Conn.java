package com;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson.sales
 * @verison 1.0.0
 */
public class Conn {

    public static Connection getConnection() {
        Connection c = null;
        try {
            Driver d = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
            String URL = "jdbc:mysql://172.16.188.128:3307/hefesto";
            c = DriverManager.getConnection(URL, "root", "secreta");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Erro:\n" + ex, "Conexão MySQL", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
}
