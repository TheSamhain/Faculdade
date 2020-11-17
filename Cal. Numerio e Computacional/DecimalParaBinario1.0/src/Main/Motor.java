package Main;

public class Motor {
    public String Converter(long valor, String de, String para) {
        DecimalHexa deciHexa = new DecimalHexa();
        BinarioDecimal binDeci = new BinarioDecimal();
        String convertido = "";
        String resultado = "";
        String binario = "";
        long resto;
        int i = 0;
        switch (de) {
            case "Decimal":
                switch (para) {
                    case "Decimal":
                        resultado = String.valueOf(valor);
                        break;
                    case "Binário":
                        while (valor > 1) {
                            resto = valor % 2;
                            convertido = convertido + Long.toString(resto);
                            valor = valor / 2;
                        }
                        break;
                    case "Octal":
                        while (valor > 7) {
                            resto = valor % 8;
                            convertido = convertido + Long.toString(resto);
                            valor = valor / 8;
                        }
                        break;
                    case "Hexadecimal":
                        while (valor > 15) {
                            resto = valor % 16;
                            if(resto > 9){
                                convertido = convertido + deciHexa.decimalHexa(Long.toString(resto));
                            } else{
                                convertido = convertido + Long.toString(resto);
                            }
                            valor = valor / 16;
                        }
                        break;
                }
                if (para.equals("Hexadecimal")) {
                    resto = valor % 16;
                    if (resto > 9) {
                        convertido = convertido + deciHexa.decimalHexa(Long.toString(valor));
                    } else {
                        convertido = convertido + Long.toString(resto);
                    }
                } else {
                    if (!para.equals("Decimal")) {
                        convertido = convertido + Long.toString(valor);
                    }
                }
                if (!para.equals("Decimal")) {
                    for (i = convertido.length() - 1; i >= 0; i--) {
                        resultado = resultado + convertido.charAt(i);
                    }
                }
                break;

            case "Binário":
                binario = String.valueOf(valor);
                for (i = 0; i < binario.length(); i++) {
                    if(!(binario.charAt(i) == '0' || binario.charAt(i) == '1')){
                        resultado = "Insira um número binário";
                        break;
                    }
                }
                if(!resultado.equals("Insira um número binário")){
                    switch (para) {
                        case "Decimal":
                            resultado = binDeci.binarioDecimal((binario.length()-1),binario);
                            break;

                        case "Binário":
                            resultado = String.valueOf(valor);
                            break;
                    }
                }
                break;
        }
        return resultado;
    }
}
