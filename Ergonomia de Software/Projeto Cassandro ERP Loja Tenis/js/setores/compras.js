function salvarCompra() {
    var rows = [];
    var tbl = $('#tbComprasProdutos tr').get().map(function (row) {
        if ($(row).find('td:eq(0)').html()) {
            produto = $(row).find('td:eq(0)').find('input').val();
            qtde = $(row).find('td:eq(1)').find('input').val();

            rows.push({ "produto": produto, "qtde": qtde });
        }
    });

    ProdutosJSON = JSON.stringify(rows);

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:3000/salvaCompra", false);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(ProdutosJSON);

    if (xhttp.response) {
        alert("Erro ao inserir Ordem");
    } else {
        location.reload();
    }

}

function selectCompras() {
    var jqxhr = $.post("http://localhost:3000/compras")
        .always(function (json) {
            var ProdutosJSON = new Array();
            ProdutosJSON = JSON.parse(json);

            ProdutosJSON.forEach(function (row) {
                var linha = "";
                linha += "<tr>";
                linha += "<th scope='row'>" + row.codigo + "</th>";
                linha += "<td>" + row.produto + "</td>";
                linha += "<td>" + row.qtde + "</td>";
                linha += "</tr>";

                $("#tbCompras tr:last").after(linha);
            });

        })
        .fail(function () {
            alert("Erro ao pesquisar produtos");
        })

}

function detalhesCompras() {
    $("#tbCompras").hide();

    $("#principal").load("../html/detalhesCompras.html");
}

function addProdutoTable() {
    var $button = $('#tbComprasProdutos tr:last').clone();
    $('#tbComprasProdutos tr:last').after($button);
}

function removeProdutoTable() {
    var tabela = $("#tbComprasProdutos tr").length;

    if (tabela > 2) {
        $('#tbComprasProdutos tr:last').remove();
    }
}
