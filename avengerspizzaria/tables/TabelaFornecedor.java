package avengerspizzaria.tables;

import avengerspizzaria.models.Fornecedor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaFornecedor extends AbstractTableModel {
    private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

    @Override
    public int getRowCount() {
        return fornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fornecedor f = fornecedores.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return f.getId();
            case 1:
                return f.getNome();
            case 2:
                return f.getCnpj();
            case 3:
                return f.getTelefone();
            case 4:
                return f.getEmail();
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
                return "CNPJ";
            case 3:
                return "Telefone";
            case 4:
                return "Email";
            default:
                return "";
        }
    }
    
    public Fornecedor getFornecedor(int row) {
        return fornecedores.get(row);
    }
    
    public void adicionar(Fornecedor f) {
        fornecedores.add(f);
        fireTableRowsInserted(fornecedores.size() - 1, fornecedores.size() - 1);
    }
    
    public void atualizar(Fornecedor f, int index) throws Exception {
        Fornecedor f2 = fornecedores.get(index);

        f2.setNome(f.getNome());
        f2.setCnpj(f.getCnpj());
        f2.setTelefone(f.getTelefone());
        f2.setEmail(f.getEmail());

        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index) {
        fornecedores.remove(index);
        fireTableRowsInserted(fornecedores.size() - 1, fornecedores.size() - 1);
    }
}