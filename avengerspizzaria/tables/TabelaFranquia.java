package avengerspizzaria.tables;

import avengerspizzaria.models.Franquia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaFranquia extends AbstractTableModel {
    private List<Franquia> franquias = new ArrayList();
    @Override
    public int getRowCount() {
        return franquias.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Franquia f = franquias.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return f.getId();
            case 1:
                return f.getNome();
            case 2:
                return f.getEndereco();
            case 3:
                return f.getFornecedor();
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
                return "Endereço";
            case 3:
                return "ID Fornecedor";
            default:
                return "";
        }
    }
    
    public Franquia getFranquia(int row) {
        return franquias.get(row);
    }
    
    public void adicionar(Franquia f) {
        franquias.add(f);
        fireTableRowsInserted(franquias.size() - 1, franquias.size() - 1);
    }
    
    public void atualizar(Franquia f, int index) throws Exception {
        Franquia f2 = franquias.get(index);

        f2.setNome(f.getNome());
        f2.setEndereco(f.getEndereco());
        f2.setFornecedor(f.getFornecedor());

        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index) {
        franquias.remove(index);
        fireTableRowsInserted(franquias.size() - 1, franquias.size() - 1);
    }
}