function salvarProduto() {
    var id = $("#codigoInterno").val();
    var codigo = $("#codigoExterno").val();
    var descricao = $("#descricao").val();
    var barras = $("#barras").val();
    var unidade = $("#unidade").val();
    var estoque = $("#estoque").val();

    if (!codigo || !descricao || !barras || !unidade || !estoque) {
        alert("Necssário inserir todas as informações para Salvar");
        return;
    }

    var xhttp = new XMLHttpRequest();

    if (id) {
        xhttp.open("POST", "http://localhost:3000/updateProduto", false);
        var data = JSON.stringify({
            "id": id,
            "codigo": codigo,
            "descricao": descricao,
            "barras": barras,
            "unidade": unidade,
            "estoque": estoque
        });
    } else {
        xhttp.open("POST", "http://localhost:3000/insertProduto", false);
        var data = JSON.stringify({
            "codigo": codigo,
            "descricao": descricao,
            "barras": barras,
            "unidade": unidade,
            "estoque": estoque
        });
    }

    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(data);

    if (xhttp.response) {
        if (xhttp.response == "Erro") {
            alert("Erro ao Salvar produto");
        } else {
            location.reload();
        }
    } else {
        alert("Erro ao realizar requisição");
    }

}

function deletarProduto() {
    var id = $("#codigoInterno").val();

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:3000/deletarProduto", false);
    xhttp.setRequestHeader("Content-Type", "application/json");
    var data = JSON.stringify({ "id": id });
    xhttp.send(data);

    if (xhttp.response) {
        if (xhttp.response == "Erro") {
            alert("Erro ao deletar produto");
        } else {
            location.reload();
        }
    } else {
        alert("Erro ao realizar requisição");
    }
}

function clickRow(row) {
    $("#codigoInterno").val(row.cells[0].firstChild.nodeValue);
    $("#codigoExterno").val(row.cells[1].firstChild.nodeValue);
    $("#descricao").val(row.cells[2].firstChild.nodeValue);
    $("#barras").val(row.cells[3].firstChild.nodeValue);
    $("#unidade").val(row.cells[4].firstChild.nodeValue);
    $("#estoque").val(row.cells[5].firstChild.nodeValue);
}

function limparCamposProdutos() {
    $("#codigoInterno").val("");
    $("#codigoExterno").val("");
    $("#descricao").val("");
    $("#barras").val("");
    $("#unidade").val("");
    $("#estoque").val("");

}

function selectTodosProdutos() {
    var jqxhr = $.post("http://localhost:3000/produtos")
        .always(function (json) {
            var ProdutosJSON = new Array();
            ProdutosJSON = JSON.parse(json);

            ProdutosJSON.forEach(function (row) {
                var linha = "";
                linha += "<tr onclick='clickRow(this)'>";
                linha += "<th scope='row' class='id' >" + row.id + "</th>";
                linha += "<td>" + row.codigo + "</td>";
                linha += "<td>" + row.descricao + "</td>";
                linha += "<td>" + row.codBarras + "</td>";
                linha += "<td>" + row.unidade + "</td>";
                linha += "<td>" + row.estoque + "</td>";
                linha += "</tr>";

                $("#tbProdutos tr:last").after(linha);
            });

        })
        .fail(function () {
            alert("Erro ao pesquisar produtos");
        })

}
