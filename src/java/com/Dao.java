package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hudson.sales
 * @verison 1.0.0
 */
public class Dao {

    public List<Contato> query(String param) {
        Connection c = null;
        List<Contato> contatos = new ArrayList<>();
        try {
            c = Conn.getConnection();
            String sql = "SELECT * FROM contatos WHERE nome LIKE '%" + param + "%' ORDER BY nome";
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Contato cont = new Contato();
                cont.setNome(rs.getString("nome"));
                cont.setEmail(rs.getString("email"));
                cont.setTel(rs.getString("tel"));
                contatos.add(cont);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return contatos;
    }

    public List<String> auto(String param) {
        Connection c = null;
        List<String> contatos = new ArrayList<>();
        try {
            c = Conn.getConnection();
            String sql = "SELECT nome FROM contatos WHERE nome LIKE '%" + param + "%' ORDER BY nome LIMIT 12";
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                contatos.add(rs.getString("nome"));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return contatos;
    }
}
