/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author batista
 */
public class Conexao {

    public static Connection con;

    public Conexao() {

    }

    public static void conecte() {
        String Driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "918171";
        String url = "jdbc:postgresql://localhost:5432/space";

        try {
            Class.forName(Driver);

            con = (Connection) DriverManager.getConnection(url, user, senha);
            System.out.println("Conexão realizada com sucesso");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void execute(String nome, int points) {//método que inseri os registros na tabela do banco
        String sql = "insert into ranking(player, points) values ('"+nome+"', "+points+")";
        try {
            PreparedStatement stmt = con.prepareCall(sql);
            Statement st = con.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String sql) {//    
        try {
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public static void main(String[] args) {
        conecte();
        execute("Vinicius", 2);
    }
    

}
