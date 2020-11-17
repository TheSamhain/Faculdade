function principal() {
    $("#principal").load("html/principal.html");
    document.getElementById("aba").innerHTML = "Principal";
    sessionStorage.removeItem("setor");
    location.reload();
}

function compras() {
    $("#principal").load("html/compras.html");
    sessionStorage.setItem("setor", "compras");
    selectCompras();
    document.getElementById("aba").innerHTML = "Compras";
}

function financeiro() {
    $("#principal").load("html/financeiro.html");
    sessionStorage.setItem("setor", "financeiro");
    selectOrdens();
    document.getElementById("aba").innerHTML = "Financeiro";
    
}

function almoxarifado() {
    $("#principal").load("html/almoxarifado.html");
    sessionStorage.setItem("setor", "almoxarifado");
    selectTodosProdutos();
    document.getElementById("aba").innerHTML = "Produtos";
}

function sair() {
    sessionStorage.clear();
    localStorage.clear();
    location.reload();
}
