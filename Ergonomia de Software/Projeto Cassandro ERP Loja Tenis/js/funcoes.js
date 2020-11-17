$("#principal").removeClass("text-center");

$(function headerInclude() {
  if (localStorage.getItem("usuario") && localStorage.getItem("senha")) {
    $("#header").load("html/header.html");
    if (sessionStorage.getItem("setor")) {
      var setor = sessionStorage.getItem("setor");
      //$("#principal").load("html/"+sessionStorage.getItem("setor")+".html");
      if (setor == "compras") {
        compras();
      }
      if (setor == "financeiro"){
        financeiro();
      }
      if (setor == "almoxarifado"){
        almoxarifado();
      }
    } else {
      principal();
    }
  }
});

$(function loginInclude() {
  if (!localStorage.getItem("usuario") && !localStorage.getItem("senha")) {
    $("#principal").load("html/login.html");
    $("#principal").addClass("text-center");
  }
});

$(function selecionarSetores(){
  var divisao = localStorage.getItem("divisao");
  if (divisao != "gerente"){
      if (divisao != "financeiro"){
          $( ".btnFinanceiro" ).remove();
      }
      if (divisao != "almoxarifado"){
          $( ".btnAlmoxarifado" ).remove();
      }
      if (divisao != "compras"){
          $( ".btnCompras" ).remove();
      }
  }
})