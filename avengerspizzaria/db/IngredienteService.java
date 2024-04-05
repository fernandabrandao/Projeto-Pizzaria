package avengerspizzaria.db;

import avengerspizzaria.models.Ingrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class IngredienteService {
    public static ArrayList<Ingrediente> get() throws Exception {
        ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "SELECT id, nome, id_tipo FROM ingredientes;";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int idTipo = rs.getInt(3);

                Ingrediente i = new Ingrediente(id, nome, idTipo);
                ingredientes.add(i);
            }

            return ingredientes;
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
    
    public static void insert(Ingrediente i) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "INSERT INTO ingredientes (nome, id_tipo) VALUES (?, ?);";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, i.getNome());
            stmt.setInt(2, i.getTipo());

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
    
    public static void update(Ingrediente i) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "UPDATE ingredientes SET nome=?, id_tipo=? WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, i.getNome());
            stmt.setInt(2, i.getTipo());
            stmt.setInt(3, i.getId());

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
    
    public static void delete(Ingrediente i) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "DELETE FROM ingredientes WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, i.getId());
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