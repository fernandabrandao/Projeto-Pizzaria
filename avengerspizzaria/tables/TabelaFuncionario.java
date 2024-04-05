package avengerspizzaria.tables;

import avengerspizzaria.models.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaFuncionario extends AbstractTableModel {
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario f = funcionarios.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return f.getId();
            case 1:
                return f.getNome();
            case 2:
                return f.getDtNasc();
            case 3:
                return f.getCpf();
            case 4:
                return f.getEndereco();
            case 5:
                return f.getEmail();
            case 6:
                return f.getTelefone();
            case 7:
                return f.getUsuario();
            case 8:
                return f.getFranquia();
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
                return "Data de Nascimento";
            case 3:
                return "CPF";
            case 4:
                return "Endereço";
            case 5:
                return "Email";
            case 6:
                return "Telefone";
            case 7:
                return "ID Usuário";
            case 8:
                return "ID Franquia";
            default:
                return "";
        }
    }
    
    public Funcionario getFuncionario(int row) {
        return funcionarios.get(row);
    }
    
    public void adicionar(Funcionario f) {
        funcionarios.add(f);
        fireTableRowsInserted(funcionarios.size() - 1, funcionarios.size() - 1);
    }
    
    public void atualizar(Funcionario f, int index) throws Exception {
        Funcionario f2 = funcionarios.get(index);

        f2.setNome(f.getNome());
        f2.setDtNasc(f.getDtNasc());
        f2.setCpf(f.getCpf());
        f2.setEndereco(f.getEndereco());
        f2.setEmail(f.getEmail());
        f2.setTelefone(f.getTelefone());
        f2.setUsuario(f.getUsuario());
        f2.setFranquia(f.getFranquia());

        fireTableRowsUpdated(index, index);
    }
    
    public void remover(int index) {
        funcionarios.remove(index);
        fireTableRowsInserted(funcionarios.size() - 1, funcionarios.size() - 1);
    }
}