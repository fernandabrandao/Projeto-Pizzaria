package avengerspizzaria.tables;

import avengerspizzaria.models.TipoIngrediente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaTipoIngrediente extends AbstractTableModel {
    private List<TipoIngrediente> tipos = new ArrayList<TipoIngrediente>();
    @Override
    public int getRowCount() {
        return tipos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoIngrediente t = tipos.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return t.getId();
            case 1:
                return t.getNome();
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
                return "Nome";
            default:
                return "";
        }
    }
    
    public TipoIngrediente getTipoIngrediente(int row) {
        return tipos.get(row);
    }
    
    public void adicionar(TipoIngrediente t) {
        tipos.add(t);
        fireTableRowsInserted(tipos.size() - 1, tipos.size() - 1);
    }
    
    public void atualizar(TipoIngrediente t, int index) throws Exception {
        TipoIngrediente t2 = tipos.get(index);

        t2.setNome(t.getNome());

        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index) {
        tipos.remove(index);
        fireTableRowsInserted(tipos.size() - 1, tipos.size() - 1);
    }
}
