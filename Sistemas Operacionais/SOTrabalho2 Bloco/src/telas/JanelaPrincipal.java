package telas;

public class JanelaPrincipal extends javax.swing.JFrame {
    
    String cript;
    String decript;
    char [] arrayinserido;
    
    //Vetor com o alfabeto em sua seqência normal
    char listaDecript [] = new char []  {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','w','y','z','ç','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','W','Y','Z','Ç','.','_',' ','/','\n','ã','á','â','é','õ'};
    //Vetor com caracteres dessorneados
    char listaCript [] = new char[]     {'Q','3','e','1','2','8','4','9','0','7','5','6','b','P','k','s','W','l','f','Ç','g','!','o','z','.','v','x','[','q','p','ç','O','i','/','R','n','V','h','H',']','B','r','G','U','T','t','K','N','M','E','F','Y','I','A','S','D','J','L','Z','C','X','u','y','a','d','@','=','|','*' ,'m','w','j','c','#'};            
    
    //Função para criptografar o texto
    public String alterarDecript(String inserido){
        //Define as variaveis
        String resultado = "";
        int i,j;
        //Quebra o texto inserido em um Array de char
        arrayinserido = inserido.toCharArray();
        //Armazena o tamanho do texto inserido
        int tam = inserido.length();
        
        //Percorre o vetor com alfabeto normal
        for(i=0;i<tam;i++){
            for(j=0;j<(listaCript.length);j++){
               if(arrayinserido[i] == listaCript[j]){
                   /*Quando encontrado um caracter igual do alfabeto normal
                     o resultado recebe o caracter da mesma posição no array contrário
                   */
                   resultado = resultado + listaDecript[j];
                   break;
                }
            }
        }
        return resultado; 
    }
    
    //Função para descriptografar o texto
     public String alterarCript(String inserido){
        //Define as variaveis
        String resultado = "";
        int i,j;
        //Quebra o texto inserido em um Array de char
        arrayinserido = inserido.toCharArray();
        //Armazena o tamanho do texto inserido
        int tam = inserido.length();
        
        //Percorre o vetor com alfabeto normal
        for(i=0;i<tam;i++){
            for(j=0;j<(listaCript.length);j++){
               if(arrayinserido[i] == listaDecript[j]){
                   //Quando encontrado um caracter igual do alfabeto normal o resultado recebe o caracter da mesma posição no array contrário
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

        btnCript = new javax.swing.JButton();
        btnDecript = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDecript = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCript = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(470, 220));
        setPreferredSize(new java.awt.Dimension(470, 220));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCript.setText("Criptografar");
        btnCript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriptActionPerformed(evt);
            }
        });
        getContentPane().add(btnCript, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 140, 30));

        btnDecript.setText("Decriptografar");
        btnDecript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecriptActionPerformed(evt);
            }
        });
        getContentPane().add(btnDecript, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, 30));

        jScrollPane1.setViewportView(txtDecript);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 250, 70));

        jScrollPane2.setViewportView(txtCript);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 70));

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txtCript;
    private javax.swing.JTextPane txtDecript;
    // End of variables declaration//GEN-END:variables
}
