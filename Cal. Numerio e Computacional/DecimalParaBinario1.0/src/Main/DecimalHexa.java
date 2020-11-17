package Main;
public class DecimalHexa {

    public String decimalHexa(String valorAtual) {
        int i;
        String retorno = "";
        String[][] hexa = new String[][]{{"10", "11", "12", "13", "14", "15"},
                                         {"A", "B", "C", "D", "E", "F"}};

        for (i = 0; i < 5; i++){
            if(valorAtual.equals(hexa[0][i])){
                retorno = hexa[1][i];
            }
        }
        
    return retorno ;
}

}