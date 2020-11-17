function aprovar(id) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:3000/aprovarOrdem", false);
    xhttp.setRequestHeader("Content-Type", "application/json");
    var data = JSON.stringify({ "id": id });
    xhttp.send(data);

    if (xhttp.response) {
        alert(xhttp.response);
    }

    location.reload();
}

function selectOrdens() {
    var jqxhr = $.post("http://localhost:3000/ordens")
        .always(function (json) {
            var OrdensJSON = new Array();
            OrdensJSON = JSON.parse(json);

            OrdensJSON.forEach(function (row) {
                var linha = "";
                linha += "<tr>";
                linha += "<th scope='row'>" + row.id + "</th>";
                if (row.processado == 1) {
                    linha += "<td><button type='button' class='btn btn-danger' disabled>Aprovado</button></td>";
                }
                else {
                    linha += "<td><button type='button' onclick='aprovar(" + row.id + ");' class='btn btn-primary'>Aprovar</button></td>";
                }
                linha += "</tr>";

                $("#tbFinanceiro tr:last").after(linha);
            });

        })
        .fail(function () {
            alert("Erro ao pesquisar produtos");
        })

}