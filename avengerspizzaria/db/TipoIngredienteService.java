package avengerspizzaria.db;

import avengerspizzaria.models.TipoIngrediente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TipoIngredienteService {
    public static ArrayList<TipoIngrediente> get() throws Exception {
        ArrayList<TipoIngrediente> tipos = new ArrayList<TipoIngrediente>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "SELECT id, nome FROM tipo_ingredientes;";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                String nome = rs.getString(2);

                TipoIngrediente t = new TipoIngrediente(id, nome);
                tipos.add(t);
            }

            return tipos;
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
    
    public static void insert(TipoIngrediente t) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "INSERT INTO tipo_ingredientes (nome) VALUES (?);";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, t.getNome());
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
    
    public static void update(TipoIngrediente t) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "UPDATE tipo_ingredientes SET nome=? WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getId());

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
    
    public static void delete(TipoIngrediente t) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "DELETE FROM tipo_ingredientes WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, t.getId());
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