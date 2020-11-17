package telas;

public class JanelaPrincipal extends javax.swing.JFrame {
    
    String cript;
    String decript;
    char listaDecript [] = new char []  {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','w','y','z','ç','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','W','Y','Z','Ç','.','_',' ','/'};
    char listaCript [] = new char[]     {'Q','3','e','1','2','8','4','9','0','7','5','6','b','P','k','s','W','l','f','Ç','g','!','o','z','.','v','x','[','q','p','ç','O','i','/','R','n','V','h','H',']','B','r','G','U','T','t','K','N','M','E','F','Y','I','A','S','D','J','L','Z','C','X','u','y','a','d','@','=','|'};
            
    char [] arrayinserido;
    
    public String alterarDecript(String inserido){
        String resultado = "";
        int i,j;
        arrayinserido = inserido.toCharArray();
        int tam = inserido.length();
        
        
        for(i=0;i<tam;i++){
            for(j=0;j<(listaCript.length);j++){
               if(arrayinserido[i] == listaCript[j]){
                    resultado = resultado + listaDecript[j];
                    break;
                }
            }
        }
        return resultado; 
    }
    
     public String alterarCript(String inserido){
        String resultado = "";
        int i,j;
        arrayinserido = inserido.toCharArray();
        int tam = inserido.length();
        
        
        for(i=0;i<tam;i++){
            for(j=0;j<(listaCript.length);j++){
               if(arrayinserido[i] == listaDecript[j]){
                    resultado = resultado + listaCript[j];
                    break;
                }
            }
        }
        return resultado; 
    }
    
    public JanelaPrincipal() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDecript = new javax.swing.JTextField();
        txtCript = new javax.swing.JTextField();
        btnCript = new javax.swing.JButton();
        btnDecript = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(470, 120));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtDecript, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 250, 20));
        getContentPane().add(txtCript, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 20));

        btnCript.setText("Criptografar");
        btnCript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriptActionPerformed(evt);
            }
        });
        getContentPane().add(btnCript, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 140, 20));

        btnDecript.setText("Decriptografar");
        btnDecript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecriptActionPerformed(evt);
            }
        });
        getContentPane().add(btnDecript, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriptActionPerformed
        cript = String.valueOf(txtCript.getText());
        decript = alterarCript(cript);
        txtDecript.setText(decript);
    }//GEN-LAST:event_btnCriptActionPerformed

    private void btnDecriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecriptActionPerformed
        decript = String.valueOf(txtDecript.getText());
        cript = alterarDecript(decript);
        txtCript.setText(cript);
    }//GEN-LAST:event_btnDecriptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCript;
    private javax.swing.JButton btnDecript;
    private javax.swing.JTextField txtCript;
    private javax.swing.JTextField txtDecript;
    // End of variables declaration//GEN-END:variables
}
