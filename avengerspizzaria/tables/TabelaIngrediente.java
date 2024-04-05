package avengerspizzaria.tables;

import avengerspizzaria.models.Ingrediente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaIngrediente extends AbstractTableModel {
    private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    @Override
    public int getRowCount() {
        return ingredientes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ingrediente i = ingredientes.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return i.getId();
            case 1:
                return i.getNome();
            case 2:
                return i.getTipo();
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
            case 2:
                return "ID Tipo";
            default:
                return "";
        }
    }
    
    public Ingrediente getIngrediente(int row) {
        return ingredientes.get(row);
    }
    
    public void adicionar(Ingrediente i) {
        ingredientes.add(i);
        fireTableRowsInserted(ingredientes.size() - 1, ingredientes.size() - 1);
    }
    
    public void atualizar(Ingrediente i, int index) throws Exception {
        Ingrediente i2 = ingredientes.get(index);

        i2.setNome(i.getNome());
        i2.setTipo(i.getTipo());

        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index) {
        ingredientes.remove(index);
        fireTableRowsInserted(ingredientes.size() - 1, ingredientes.size() - 1);
    }
    
}
