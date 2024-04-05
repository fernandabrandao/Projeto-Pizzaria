package avengerspizzaria.db;

import avengerspizzaria.models.Pizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PizzaService {
    public static ArrayList<Pizza> get() throws Exception {
        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "SELECT id, nome, preco, tamanho FROM pizza;";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                double preco = rs.getDouble(3);
                String tamanho = rs.getString(4);

                Pizza p = new Pizza(id, nome, preco, tamanho);
                pizzas.add(p);
            }

            return pizzas;
        }
        finally
        {
            if (rs != null)
                rs.close();

            if (stmt != null)
                stmt.close();

            if (conn != null)
                ConnManager.closeConnection(conn);
        }
    }
    
    public static void insert(Pizza p) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "INSERT INTO pizza (nome, preco, tamanho) VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setString(3, p.getTamanho());

            stmt.execute();
        }
        finally
        {
            if (stmt != null)
                stmt.close();

            if (conn != null)
                ConnManager.closeConnection(conn);
        }
    }
    
    public static void update(Pizza p) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "UPDATE pizza SET nome=?, preco=?, tamanho=? WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setString(3, p.getTamanho());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();
        }
        finally
        {
            if (stmt != null)
                stmt.close();

            if (conn != null)
                ConnManager.closeConnection(conn);
        }
    }
    
    public static void delete(Pizza p) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "DELETE FROM pizza WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, p.getId());
            stmt.execute();
        }
        finally
        {
            if (stmt != null)
                stmt.close();

            if (conn != null)
                ConnManager.closeConnection(conn);
        }
    }
}