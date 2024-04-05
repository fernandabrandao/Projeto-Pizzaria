package avengerspizzaria.db;

import avengerspizzaria.models.Lote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoteService {
    public static ArrayList<Lote> get() throws Exception {
        ArrayList<Lote> lotes = new ArrayList<Lote>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "SELECT id, dt_compra, dt_validade, qtd, preco, id_ingredientes FROM lote;";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                String dtCompra = rs.getDate(2).toString();
                String dtValidade = rs.getDate(3).toString();
                int qtd = rs.getInt(4);
                double preco = rs.getDouble(5);
                int ingrediente = rs.getInt(6);

                Lote l = new Lote(id, dtCompra, dtValidade, qtd, preco, ingrediente);
                lotes.add(l);
            }

            return lotes;
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
    
    public static void insert(Lote l) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "INSERT INTO lote (dt_compra, dt_validade, qtd, preco, id_ingredientes) VALUES (?, ?, ?, ?, ?);";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, l.getDtCompra());
            stmt.setString(2, l.getDtValidade());
            stmt.setInt(3, l.getQtd());
            stmt.setDouble(4, l.getPreco());
            stmt.setInt(5, l.getIngrediente());

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
    
    public static void update(Lote l) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "UPDATE lote SET dt_compra=?, dt_validade=?, qtd=?, preco=?, id_ingredientes=? WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, l.getDtCompra());
            stmt.setString(2, l.getDtValidade());
            stmt.setInt(3, l.getQtd());
            stmt.setDouble(4, l.getPreco());
            stmt.setInt(5, l.getIngrediente());
            stmt.setInt(6, l.getId());

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
    
    public static void delete(Lote l) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = ConnManager.getConnection();

            String query = "DELETE FROM lote WHERE id=?;";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, l.getId());
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