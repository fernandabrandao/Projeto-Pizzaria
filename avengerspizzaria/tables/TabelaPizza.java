package avengerspizzaria.tables;

import avengerspizzaria.models.Pizza;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaPizza extends AbstractTableModel {
    private List<Pizza> pizzas = new ArrayList<Pizza>();
    @Override
    public int getRowCount() {
        return pizzas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pizza p = pizzas.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getNome();
            case 2:
                return p.getPreco();
            case 3:
                return p.getTamanho();
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
                return "Preço";
            case 3:
                return "Tamanho";
            default:
                return "";
        }
    }
    
    public Pizza getPizza(int row) {
        return pizzas.get(row);
    }
    
    public void adicionar(Pizza p) {
        pizzas.add(p);
        fireTableRowsInserted(pizzas.size() - 1, pizzas.size() - 1);
    }
    
    public void atualizar(Pizza p, int index) throws Exception {
        Pizza p2 = pizzas.get(index);

        p2.setNome(p.getNome());
        p2.setPreco(p.getPreco());
        p2.setTamanho(p.getTamanho());

        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index) {
        pizzas.remove(index);
        fireTableRowsInserted(pizzas.size() - 1, pizzas.size() - 1);
    }
    
}
