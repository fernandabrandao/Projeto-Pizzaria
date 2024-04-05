package avengerspizzaria.visual;

public class MenuJFrame extends javax.swing.JFrame {

    public MenuJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btUsuario = new javax.swing.JButton();
        btFuncionario = new javax.swing.JButton();
        btIngrediente = new javax.swing.JButton();
        btTipoIngrediente = new javax.swing.JButton();
        btLote = new javax.swing.JButton();
        btFranquia = new javax.swing.JButton();
        btFornecedor = new javax.swing.JButton();
        btPizza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("BEM-VINDO");

        btUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btUsuario.setText("Usuário");
        btUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuarioActionPerformed(evt);
            }
        });

        btFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btFuncionario.setText("Funcionário");
        btFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFuncionarioActionPerformed(evt);
            }
        });

        btIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btIngrediente.setText("Ingrediente");
        btIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngredienteActionPerformed(evt);
            }
        });

        btTipoIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btTipoIngrediente.setText("Tipo de Ingrediente");
        btTipoIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTipoIngredienteActionPerformed(evt);
            }
        });

        btLote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btLote.setText("Lote");
        btLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoteActionPerformed(evt);
            }
        });

        btFranquia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btFranquia.setText("Franquia");
        btFranquia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFranquiaActionPerformed(evt);
            }
        });

        btFornecedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btFornecedor.setText("Fornecedor");
        btFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFornecedorActionPerformed(evt);
            }
        });

        btPizza.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btPizza.setText("Pizza");
        btPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPizzaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btFuncionario)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btFornecedor)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btFranquia)
                                .addGap(18, 18, 18)
                                .addComponent(btPizza)
                                .addGap(18, 18, 18)
                                .addComponent(btLote)))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btTipoIngrediente)
                        .addGap(18, 18, 18)
                        .addComponent(btIngrediente)
                        .addGap(11, 11, 11))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btUsuario)
                    .addComponent(btTipoIngrediente)
                    .addComponent(btIngrediente))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFranquia)
                    .addComponent(btFuncionario)
                    .addComponent(btPizza)
                    .addComponent(btLote))
                .addGap(30, 30, 30)
                .addComponent(btFornecedor)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngredienteActionPerformed
        CrudIngredienteJFrame ingrediente = new CrudIngredienteJFrame();
        ingrediente.setVisible(true);
    }//GEN-LAST:event_btIngredienteActionPerformed

    private void btTipoIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTipoIngredienteActionPerformed
        CrudTipoIngredienteJFrame tipoIngrediente = new CrudTipoIngredienteJFrame();
        tipoIngrediente.setVisible(true);
    }//GEN-LAST:event_btTipoIngredienteActionPerformed

    private void btLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoteActionPerformed
        CrudLoteJFrame lote = new CrudLoteJFrame();
        lote.setVisible(true);
    }//GEN-LAST:event_btLoteActionPerformed

    private void btUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuarioActionPerformed
        CrudUsuarioJFrame usuario = new CrudUsuarioJFrame();
        usuario.setVisible(true);
    }//GEN-LAST:event_btUsuarioActionPerformed

    private void btFranquiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFranquiaActionPerformed
        CrudFranquiaJFrame franquia = new CrudFranquiaJFrame();
        franquia.setVisible(true);
    }//GEN-LAST:event_btFranquiaActionPerformed

    private void btPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPizzaActionPerformed
        CrudPizzaJFrame pizza = new CrudPizzaJFrame();
        pizza.setVisible(true);
    }//GEN-LAST:event_btPizzaActionPerformed

    private void btFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFuncionarioActionPerformed
        CrudFuncionarioJFrame funcionario = new CrudFuncionarioJFrame();
        funcionario.setVisible(true);
    }//GEN-LAST:event_btFuncionarioActionPerformed

    private void btFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFornecedorActionPerformed
        CrudFornecedorJFrame fornecedor = new CrudFornecedorJFrame();
        fornecedor.setVisible(true);
    }//GEN-LAST:event_btFornecedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFornecedor;
    private javax.swing.JButton btFranquia;
    private javax.swing.JButton btFuncionario;
    private javax.swing.JButton btIngrediente;
    private javax.swing.JButton btLote;
    private javax.swing.JButton btPizza;
    private javax.swing.JButton btTipoIngrediente;
    private javax.swing.JButton btUsuario;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}