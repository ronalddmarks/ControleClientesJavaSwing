package br.com.mca.view;

import br.com.mca.util.ConnectionFactory;
import br.com.mca.util.Util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PesquisaView extends javax.swing.JFrame {

    private String nomeCliente;
    private DefaultTableModel model;

    public PesquisaView() {
        initComponents();

        carregarDadosTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPesquisaNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Data de nascimento", "Fone"
            }
        ));
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpar)
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnLimpar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtPesquisaNome.setText("");
        btnPesquisarActionPerformed(evt);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        ListSelectionModel tableSelectionModel = tabelaClientes.getSelectionModel();
        // limpeza de cache
        
        tabelaClientes.setSelectionModel(tableSelectionModel);
        
        setNomeCliente(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 1).toString());
        txtPesquisaNome.setText(getNomeCliente());
        
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        model = (DefaultTableModel) tabelaClientes.getModel();
        TableRowSorter sorter = new TableRowSorter<TableModel>(model);
        tabelaClientes.setRowSorter(sorter);
        
        String nome = txtPesquisaNome.getText();
        
        if (nome != null) {
            sorter.setRowFilter(RowFilter.regexFilter(("(?i)" + nome)));
            
        }else{
            sorter.setRowFilter(null);
        }
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField txtPesquisaNome;
    // End of variables declaration//GEN-END:variables

    private void carregarDadosTabela() {

        String sql = "select cli_cod, cli_nome, cli_cpf, cli_sexo, cli_dt_nasc, cli_fone from cliente order by cli_cod";

        try {

            Connection connection = ConnectionFactory.getConexao();
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            tabelaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(180);
            tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabelaClientes.getColumnModel().getColumn(4).setPreferredWidth(105);
    

            model = (DefaultTableModel) tabelaClientes.getModel();

            while (rs.next()) {
                Integer rsCodigo = rs.getInt("cli_cod");
                String rsNome = rs.getString("cli_nome");
                String rsCpf = rs.getString("cli_cpf");

                String rsSexo = rs.getString("cli_sexo");
                if (rsSexo.equals("M")) {
                    rsSexo = "Masculino";
                } else {
                    rsSexo = "Feminino";
                }

                Date rsNasc = (Date) rs.getDate("cli_dt_nasc");

                String rsFone = rs.getString("cli_fone");

                //preenche os dados da Jtacle que estao retornando do banco de dados
                model.addRow(new Object[]{rsCodigo, rsNome, rsCpf, rsSexo, Util.ConvertToString(rsNasc), rsFone});

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}
