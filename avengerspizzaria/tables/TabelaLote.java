package avengerspizzaria.tables;

import avengerspizzaria.models.Lote;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaLote extends AbstractTableModel {
    private List<Lote> lotes = new ArrayList<Lote>();
    @Override
    public int getRowCount() {
        return lotes.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lote l = lotes.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return l.getId();
            case 1:
                return l.getDtCompra();
            case 2:
                return l.getDtValidade();
            case 3:
                return l.getQtd();
            case 4:
                return l.getPreco();
            case 5:
                return l.getIngrediente();
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
                return "Data da Compra";
            case 2:
                return "Data da Validade";
            case 3:
                return "Quantidade";
            case 4:
                return "Preço";
            case 5:
                return "ID Ingrediente";
            default:
                return "";
        }
    }
    
    public Lote getLote(int row) {
        return lotes.get(row);
    }
    
    public void adicionar(Lote l) {
        lotes.add(l);
        fireTableRowsInserted(lotes.size() - 1, lotes.size() - 1);
    }
    
    public void atualizar(Lote l, int index) throws Exception {
        Lote l2 = lotes.get(index);

        l2.setDtCompra(l.getDtCompra());
        l2.setDtValidade(l.getDtValidade());
        l2.setQtd(l.getQtd());
        l2.setPreco(l.getPreco());
        l2.setIngrediente(l.getIngrediente());

        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index) {
        lotes.remove(index);
        fireTableRowsInserted(lotes.size() - 1, lotes.size() - 1);
    }
    
}
