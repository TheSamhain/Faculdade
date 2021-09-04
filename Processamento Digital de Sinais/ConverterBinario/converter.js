var decimal = 0;
var binario = 0;
var i = 0;
var retorno = "";

function somenteBinario(num) {
    var er = /[^0-1.]/;
    er.lastIndex = 0;

    if (er.test(num.value)) {
        num.value = "";
    }
}

function somenteNumero(num) {
    var er = /[^0-9.]/;
    er.lastIndex = 0;

    if (er.test(num.value)) {
        num.value = "";
    }
}

function potencia(valor) {
    var j = 0;
    var base = 1;

    if (valor == 0) {
        return 1;
    }

    for (j = 0; j < valor; j++) {
        base *= 2;
    }

    return parseInt(base);
}

function converterBinario() {
    var inputDecimal = document.getElementById("textodecimal");
    var binario = document.getElementById("textobinario").value;
    var elevado = 0;
    var result
    inputDecimal.value = ""
    retorno = 0;

    if (binario == "") {
        return;
    }

    for (i = (binario.length - 1); i >= 0; i--) {
        if (binario.charAt(i) == "1") {
            retorno += potencia(elevado);
        }

        elevado++;
    }

    inputDecimal.value = retorno;
}

function converterDecimal() {
    var inputBinario = document.getElementById("textobinario");
    var decimal = document.getElementById("textodecimal").value;
    retorno = "";
    inputBinario.value = ""

    if (decimal == "") {
        return;
    }

    if (decimal == 0) {
        inputBinario.value = "0";
    }

    while (decimal > 0) {
        retorno += (decimal % 2);
        decimal = parseInt(decimal / 2);
    }

    for (i = (retorno.length - 1); i >= 0; i--) {
        inputBinario.value += retorno.charAt(i);
    }
}