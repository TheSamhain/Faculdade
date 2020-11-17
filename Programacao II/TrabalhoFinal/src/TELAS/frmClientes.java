package TELAS;

import DAO.ClientesDAO;
import Javabeans.Clientes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmClientes extends javax.swing.JFrame {

    //metodo listar
    public void Listar(){
        try{
            //executar o select
            ClientesDAO dao = new ClientesDAO();
            List<Clientes> listadeclientes = dao.ListarClientes();
            
            //colocar dados na tabela
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.setNumRows(0);
            
            for(Clientes c:listadeclientes){
                    modelo.addRow(new Object[]{
                    c.getIdcliente(),
                    c.getNome(),
                    c.getTelefone(),
                    c.getEmail()
                });
            }
        }catch(Exception e){
            
        }
    }
    
    public void Buscar(){
        try{
            String nome = txtbusca.getText();
    
            //executar o select
            ClientesDAO dao = new ClientesDAO();
            List<Clientes> listadeclientes = dao.ListarClientesPorNome(nome);
            
            //colocar dados na tabela
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.setNumRows(0);
            
            for(Clientes c:listadeclientes){
                    modelo.addRow(new Object[]{
                    c.getIdcliente(),
                    c.getNome(),
                    c.getTelefone(),
                    c.getEmail()
                });
            }
        }catch(Exception e){
            
        }    
    }
    
    public frmClientes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txttelefone = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        btnnovo = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btvexcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtbusca = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Controle de Clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nome:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel2.setMaximumSize(new java.awt.Dimension(76, 17));
        jLabel2.setMinimumSize(new java.awt.Dimension(76, 17));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 70, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Telefone:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 80, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Email:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel4.setMaximumSize(new java.awt.Dimension(76, 17));
        jLabel4.setMinimumSize(new java.awt.Dimension(76, 17));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 80, -1));
        getContentPane().add(txtnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 290, -1));
        getContentPane().add(txttelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 290, -1));
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 290, -1));

        btnnovo.setText("NOVO");
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });
        getContentPane().add(btnnovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 90, 40));

        btnsalvar.setText("SALVAR");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 90, 40));

        btneditar.setText("EDITAR");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });
        getContentPane().add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 90, 40));

        btvexcluir.setText("EXCLUIR");
        btvexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvexcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btvexcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, 40));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Telefone", "Email"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 470, 210));

        jLabel5.setText("Código:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        txtcodigo.setEditable(false);
        getContentPane().add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 60, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Nome: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtbusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscaActionPerformed(evt);
            }
        });
        jPanel1.add(txtbusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 260, -1));

        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 450, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        try {
            Clientes obj = new Clientes();
            obj.setNome(txtnome.getText());
            obj.setTelefone(txttelefone.getText());
            obj.setEmail(txtemail.getText());

            ClientesDAO dao = new ClientesDAO();
            dao.cadastrarCliente(obj);

            JOptionPane.showMessageDialog(null, "cadastro realizado com sucesso");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "erro ao cadastrar: " + erro);
        }
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //Listando dados na tabela
        Listar();      
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // pegar dados de um cliente
        txtcodigo.setText(tabela.getValueAt(tabela.getSelectedRow(),0).toString());
        txtnome.setText(tabela.getValueAt(tabela.getSelectedRow(),1).toString());
        txttelefone.setText(tabela.getValueAt(tabela.getSelectedRow(),2).toString());
        txtemail.setText(tabela.getValueAt(tabela.getSelectedRow(),3).toString());
    }//GEN-LAST:event_tabelaMouseClicked

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        try { 
            Clientes obj = new Clientes();
            
            obj.setIdcliente(Integer.parseInt(txtcodigo.getText()));
            obj.setNome(txtnome.getText());
            obj.setTelefone(txttelefone.getText());
            obj.setEmail(txtemail.getText());

            ClientesDAO dao = new ClientesDAO();
            dao.alterarCliente(obj);

            JOptionPane.showMessageDialog(null, "alteração realizada com sucesso");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "erro ao alterar: " + erro);
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btvexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvexcluirActionPerformed
        try { 
            Clientes obj = new Clientes();
            
            obj.setIdcliente(Integer.parseInt(txtcodigo.getText()));

            ClientesDAO dao = new ClientesDAO();
            dao.excluirCliente(obj);

            JOptionPane.showMessageDialog(null, "cliente excluido com sucesso");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "erro ao excluir: " + erro);
        }
    }//GEN-LAST:event_btvexcluirActionPerformed

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
        txtcodigo.setText(null);
        txtnome.setText(null);
        txttelefone.setText(null);
        txtemail.setText(null);

    }//GEN-LAST:event_btnnovoActionPerformed

    private void txtbuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscaActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_btnbuscarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmClientes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnnovo;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JButton btvexcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txttelefone;
    // End of variables declaration//GEN-END:variables
}
