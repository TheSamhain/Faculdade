package Main;

public class BinarioDecimal {
    public String binarioDecimal(int tamanho,String binario) {
        double retorno = 0;
        int i = 0;
        int k =0;
        int binarioAtual;
        
        for(i=tamanho;i>=0;i--){
            binarioAtual = Character.getNumericValue(binario.charAt(k));
            if (binarioAtual == 1) {
                retorno = retorno + potencia(i);
            }
            k++;
        }

        return String.format("%.0f", retorno);
    }
    
    double potencia(int i){
        int base = 2;
        double resultado = 1;
        int j = 0;

        if (i > 1) {
            for (j = 0; j < i; j++) {
                resultado = resultado * base;
            }
        } else {
            if (i == 0) {
                resultado = 1;
            }
            if (i == 1){
                resultado = 2;
            }
        }

        return resultado;
    }
}
