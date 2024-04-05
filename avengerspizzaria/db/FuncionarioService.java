package avengerspizzaria.db;

import avengerspizzaria.models.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioService {
    public static ArrayList<Funcionario> get() throws Exception {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "SELECT id, nome, dt_nascimento, endereco, cpf, email, telefone, id_usuario, id_franquia FROM funcionario;";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String dtNasc = rs.getDate(3).toString();
                String endereco = rs.getString(4);
                String cpf = rs.getString(5);
                String email = rs.getString(6);
                String telefone = rs.getString(7);
                int idUsuario = rs.getInt(8);
                int idFranquia = rs.getInt(9);

                Funcionario f = new Funcionario(id, nome, dtNasc, cpf, endereco, email, telefone, idUsuario, idFranquia);
                funcionarios.add(f);
            }

            return funcionarios;
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

    public static void insert(Funcionario f) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "INSERT INTO funcionario (nome, dt_nascimento, endereco, cpf, email, telefone, id_usuario, id_franquia) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getDtNasc());
            stmt.setString(3, f.getEndereco());
            stmt.setString(4, f.getCpf());
            stmt.setString(5, f.getEmail());
            stmt.setString(6, f.getTelefone());
            stmt.setInt(7, f.getUsuario());
            stmt.setInt(8, f.getFranquia());

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

    public static void update(Funcionario f) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "UPDATE funcionario SET nome=?, dt_nascimento=?, endereco=?, cpf=?, email=?, telefone=?, id_usuario=?, id_franquia=? WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getDtNasc());
            stmt.setString(3, f.getEndereco());
            stmt.setString(4, f.getCpf());
            stmt.setString(5, f.getEmail());
            stmt.setString(6, f.getTelefone());
            stmt.setInt(7, f.getUsuario());
            stmt.setInt(8, f.getFranquia());
            stmt.setInt(9, f.getId());

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

    public static void delete(Funcionario f) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "DELETE FROM funcionario WHERE id=?;";
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
