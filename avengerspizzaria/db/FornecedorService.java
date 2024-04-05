package avengerspizzaria.db;

import avengerspizzaria.models.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FornecedorService {
    public static ArrayList<Fornecedor> get() throws Exception {
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "SELECT id, nome, cnpj, telefone, email FROM fornecedor;";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String cnpj = rs.getString(3);
                String telefone = rs.getString(4);
                String email = rs.getString(5);

                Fornecedor f = new Fornecedor(id, nome, cnpj, telefone, email);
                fornecedores.add(f);
            }

            return fornecedores;
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

    public static void insert(Fornecedor f) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "INSERT INTO fornecedor (nome, cnpj, telefone, email) VALUES (?, ?, ?, ?);";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getEmail());

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

    public static void update(Fornecedor f) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "UPDATE fornecedor SET nome=?, cnpj=?, telefone=?, email=? WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getEmail());
            stmt.setInt(5, f.getId());

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

    public static void delete(Fornecedor f) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "DELETE FROM fornecedor WHERE id=?;";
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