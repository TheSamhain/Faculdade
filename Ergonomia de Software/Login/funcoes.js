function ValidarCPF() {
    var Soma;
    var Resto;
    Soma = 0;
    var strCPF = document.getElementById("CPF").value;
    strCPF = strCPF.replace(/[^\d]/g, "");
    var erroCPF = document.getElementById("erroCPF");

    if (strCPF == "00000000000") {
        erroCPF.style.display = "block";
        document.getElementById("CPF").value = "";
        return;
    }

    for (i = 1; i <= 9; i++)
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);

    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11))
        Resto = 0;

    if (Resto != parseInt(strCPF.substring(9, 10))) {
        erroCPF.style.display = "block";
        document.getElementById("CPF").value = "";
        return;
    }

    Soma = 0;

    for (i = 1; i <= 10; i++)
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);

    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;

    if (Resto != parseInt(strCPF.substring(10, 11))) {
        erroCPF.style.display = "block";
        document.getElementById("CPF").value = "";
        return;
    }

    erroCPF.style.display = "none";
    //retira os caracteres indesejados...
    strCPF = strCPF.replace(/[^\d]/g, "");

    //realizar a formatação...
    document.getElementById("CPF").value = strCPF.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");

}

function ValidarCEP() {
    erroCEP = document.getElementById("erroCEP");
    CEP = document.getElementById("CEP").value;
    CEP = CEP.replace(/[^\d]/g, "");
    url = 'https://viacep.com.br/ws/' + CEP + '/json/';

    $.getJSON(url, function(retorno) {
        if (("erro" in retorno)) {
            erroCEP.style.display = "block";
            document.getElementById("CEP").value = "";
            document.getElementById("Cidade").value = "";
            document.getElementById("Bairro").value = "";
            document.getElementById("Rua").value = "";
            document.getElementById("UF").value = "";
        } else {
            document.getElementById("CEP").value = retorno.cep;
            document.getElementById("Cidade").value = retorno.localidade;
            document.getElementById("Bairro").value = retorno.bairro;
            document.getElementById("Rua").value = retorno.logradouro;
            document.getElementById("UF").value = retorno.uf;
        }
    });
}

function paginaExibir() {
    query = location.search;
    var parametrosDaUrl = query.split("?")[1];
    if (parametrosDaUrl.indexOf('Cadastrar') != -1) {
        document.getElementById("conteudo").style.display = "none";
        document.getElementById("Cadastrado").style.display = "block";
    }
}