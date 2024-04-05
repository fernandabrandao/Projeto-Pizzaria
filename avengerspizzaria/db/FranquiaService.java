package avengerspizzaria.db;

import avengerspizzaria.models.Franquia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FranquiaService {
    public static ArrayList<Franquia> get() throws Exception {
        ArrayList<Franquia> franquias = new ArrayList<Franquia>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "SELECT id, nome, endereco, id_fornecedor FROM franquia;";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                int idFornecedor = rs.getInt(4);

                Franquia f = new Franquia(id, nome, endereco, idFornecedor);
                franquias.add(f);
            }

            return franquias;
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

    public static void insert(Franquia f) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "INSERT INTO franquia (nome, endereco, id_fornecedor) VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEndereco());
            stmt.setInt(3, f.getFornecedor());

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

    public static void update(Franquia f) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "UPDATE franquia SET nome=?, endereco=?, id_fornecedor=? WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEndereco());
            stmt.setInt(3, f.getFornecedor());
            stmt.setInt(4, f.getId());

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

    public static void delete(Franquia f) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "DELETE FROM franquia WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, f.getId());
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