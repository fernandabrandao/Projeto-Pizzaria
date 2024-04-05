package avengerspizzaria.visual;

import avengerspizzaria.db.IngredienteService;
import avengerspizzaria.db.TipoIngredienteService;
import avengerspizzaria.models.Ingrediente;
import avengerspizzaria.models.TipoIngrediente;
import avengerspizzaria.tables.TabelaIngrediente;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class CrudIngredienteJFrame extends javax.swing.JFrame {
   private HashMap<String, Integer> selectTipoMap = new HashMap<String, Integer>();
    
    private TabelaIngrediente tabelaIngrediente = new TabelaIngrediente();
    private int indexSelecionado = -1;

    public CrudIngredienteJFrame() {
        initComponents();

        getIngredientes();
        getTiposIngredientes();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btExcluir = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btCadastro = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        selectTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cadastro de ingrediente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btCadastro.setText("Cadastrar");
        btCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tipo:");

        table.setModel(tabelaIngrediente);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btCadastro))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(selectTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(152, 152, 152))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btVoltar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(selectTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btCadastro)
                    .addComponent(btAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    public void limparcampos(){
        this.indexSelecionado = -1;
        txtNome.setText("");
        selectTipo.setSelectedItem(null);
    }
    
    
    private void getIngredientes() {
        try
        {
            while (this.tabelaIngrediente.getRowCount() > 0) {
                this.tabelaIngrediente.remover(0);
            }

            for (Ingrediente ingrediente : IngredienteService.get()) {
                this.tabelaIngrediente.adicionar(ingrediente);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao carregar ingredientes", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void getTiposIngredientes() {
        try
        {
            for (TipoIngrediente tipo : TipoIngredienteService.get()) {
                this.selectTipoMap.put(tipo.getNome(), tipo.getId());
                this.selectTipo.addItem(tipo.getNome());
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao carregar tipo de ingredientes", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
       if (this.indexSelecionado == -1)
            return;

        try
        {
            Ingrediente i = this.tabelaIngrediente.getIngrediente(this.indexSelecionado);
            IngredienteService.delete(i);

            this.tabelaIngrediente.remover(this.indexSelecionado);
            this.limparcampos();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao deletar ingrediente", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        if (indexSelecionado == -1)
            return;

        boolean validacao = true;
        try
        {
            int tipo = this.selectTipoMap.get(this.selectTipo.getSelectedItem());

            Ingrediente i = this.tabelaIngrediente.getIngrediente(this.indexSelecionado);
            i.setNome(this.txtNome.getText());
            i.setTipo(tipo);
            validacao = false;

            IngredienteService.update(i);
            this.tabelaIngrediente.atualizar(i, this.indexSelecionado);

            this.limparcampos();
        }
        catch (Exception e)
        {
            String title = validacao ? "Validação" : "Erro";
            int pane = validacao ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;

            JOptionPane.showMessageDialog(this, e.getMessage(), title, pane);
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroActionPerformed
        if (this.indexSelecionado != -1)
            return;

        boolean validacao = true;
        try
        {
            int tipo = this.selectTipoMap.get(this.selectTipo.getSelectedItem());

            Ingrediente i = new Ingrediente(txtNome.getText(), tipo);
            validacao = false;

            IngredienteService.insert(i);

            this.getIngredientes();
            this.limparcampos();
        }
        catch (Exception e)
        {            
            String title = validacao ? "Validação" : "Erro";
            int pane = validacao ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;

            JOptionPane.showMessageDialog(this, e.getMessage(), title, pane);
        }
    }//GEN-LAST:event_btCadastroActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       Ingrediente i = tabelaIngrediente.getIngrediente(table.getSelectedRow());
        
        int tipoValor = i.getTipo();
        
        String tipoTexto = "";
        
        for (Map.Entry<String, Integer> entry : selectTipoMap.entrySet()) {
            if (entry.getValue() == tipoValor) {
                tipoTexto = entry.getKey();
                break;
            }
        }
        
        this.txtNome.setText(i.getNome());
        this.selectTipo.setSelectedItem(tipoTexto);

        this.indexSelecionado = table.getSelectedRow();
    }//GEN-LAST:event_tableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCadastro;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> selectTipo;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
