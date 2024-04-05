package avengerspizzaria.tables;

import avengerspizzaria.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaUsuario extends AbstractTableModel {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario u = usuarios.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return u.getId();
            case 1:
                return u.getEmail();
            case 2:
                return u.getLogin();
            case 3:
                return u.getSenha();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "ID";
            case 1:
                return "Email";
            case 2:
                return "Login";
            case 3:
                return "Senha";
            default:
                return "";
        }
    }
    
    public Usuario getUsuario(int row) {
        return usuarios.get(row);
    }
    
    public void adicionar(Usuario u) {
        usuarios.add(u);
        fireTableRowsInserted(usuarios.size() - 1, usuarios.size() - 1);
    }
    
    public void atualizar(Usuario u, int index) throws Exception {
        Usuario u2 = usuarios.get(index);

        u2.setEmail(u.getEmail());
        u2.setLogin(u.getLogin());
        u2.setSenha(u.getSenha());

        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index) {
        usuarios.remove(index);
        fireTableRowsInserted(usuarios.size() - 1, usuarios.size() - 1);
    }
}
