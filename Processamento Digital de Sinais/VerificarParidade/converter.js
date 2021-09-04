function verificarParidade() {
    var texto = document.getElementById("texto").value;
    var qtde = 0;

    if (texto == "") {
        document.getElementById("resultado").value = "";
        return;
    }

    for (var i = 0; i < (texto.length); i++) {
        if (texto.charAt(i) == 1) {
            qtde++;
        }
    }


    var resto = qtde % 2;

    if (resto == 0) {
        document.getElementById("resultado").value = "par";
    } else {
        document.getElementById("resultado").value = "impar";
    }
}

function somenteBinario(num) {
    var er = /[^0-1.]/;
    er.lastIndex = 0;

    if (er.test(num.value)) {
        num.value = "";
    }
}