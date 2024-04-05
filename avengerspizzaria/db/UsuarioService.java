package avengerspizzaria.db;

import avengerspizzaria.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioService {
    public static ArrayList<Usuario> get() throws Exception {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "SELECT id, email, login, senha FROM usuario;";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                String email = rs.getString(2);
                String login = rs.getString(3);
                String senha = rs.getString(4);

                Usuario u = new Usuario(id, email, login, senha);
                usuarios.add(u);
            }

            return usuarios;
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

    public static void insert(Usuario u) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "INSERT INTO usuario (email, login, senha) VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());

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

    public static void update(Usuario u) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "UPDATE usuario SET email=?, login=?, senha=? WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, u.getId());

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

    public static void delete(Usuario u) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "DELETE FROM usuario WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, u.getId());
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
    
    public static boolean checkLogin(String login, String senha) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "SELECT id FROM usuario WHERE login=? AND senha=?;";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            return rs.next();
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
}