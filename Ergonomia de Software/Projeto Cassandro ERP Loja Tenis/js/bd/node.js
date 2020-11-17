const mysql = require('mysql');
const express = require('express');
var app = express();
var cors = require('cors');
const bodyparser = require('body-parser');

app.use(bodyparser.json());

app.use(cors({
  origin: "*"
}));

var con = mysql.createConnection({
  host: "localhost",
  user: "usrteste",
  password: "usrteste",
  port: 3306,
  database: 'projetovendas',
  multipleStatements: true
});

con.connect(function (err) {
  if (!err)
    console.log('DB connection succeded.');
  else
    console.log('DB connection failed \n Error : ' + JSON.stringify(err, undefined, 2));
});

app.listen(3000, () => console.log('Express server is runnig at port no : 3000'));

//Exemplo get all -> Chamada para obter é localhost:3000/usuarios
app.post('/usuarios', (req, res) => {
  con.query('SELECT Count(*) as Count, ifnull(divisao,"") as Divisao FROM usuarios WHERE nome = ? AND senha = ?', [req.body.usuario, req.body.senha], (err, rows, fields) => {
    if (!err) {
      if (rows[0].Count > 0) {
        res.send(rows[0].Divisao);
      } else {
        res.send("Não Conectou");
      }
    }
    else {
      res.send("Erro");
    }
  })
});

// ALMOXARIFADO 
// -- Pesquisar Produtos
app.post('/produtos', (req, res) => {
  con.query('SELECT * FROM produtos', (err, rows, fields) => {
    if (!err) {
      var ProdutosJSON = [];
      rows.forEach(function (row) {
        ProdutosJSON.push({ "id": row.id, "codigo": row.codigo, "descricao": row.descricao, "codBarras": row.codBarras, "unidade": row.unidade, "foraLinha": row.foraLinha, "estoque": row.estoque });
      });

      res.send(JSON.stringify(ProdutosJSON));
    }
    else {
      res.send("Erro");
    }
  })
});
// Deletar produto
app.post('/deletarProduto', (req, res) => {
  con.query('DELETE FROM produtos WHERE id = ?', [req.body.id], (err, rows, fields) => {
    if (!err) {
      res.send("Deletou");
    }
    else {
      res.send("Erro");
    }
  })
});
// Upate produto
app.post('/updateProduto', (req, res) => {
  var reqJSON = req.body;
  con.query('UPDATE produtos SET codigo = ? , descricao = ? , codBarras = ? , unidade = ? , estoque = ? WHERE id = ?', [reqJSON.codigo, reqJSON.descricao, reqJSON.barras, reqJSON.unidade, reqJSON.estoque, reqJSON.id], (err, rows, fields) => {
    if (!err) {
      res.send("Atualizado");
    }
    else {
      res.send("Erro");
    }
  })
});

// Insert produto
app.post('/insertProduto', (req, res) => {
  var reqJSON = req.body;
  con.query('INSERT INTO produtos (codigo, descricao, codBarras, unidade, estoque) values ( ? , ? , ? , ? , ? )', [reqJSON.codigo, reqJSON.descricao, reqJSON.barras, reqJSON.unidade, reqJSON.estoque], (err, rows, fields) => {
    if (!err) {
      res.send("Inserido");
    }
    else {
      res.send("Erro");
    }
  })
});



// FINANCEIRO -- Pesquisar ordens de compra
app.post('/ordens', (req, res) => {
  con.query('SELECT * FROM ordenscompra', (err, rows, fields) => {
    if (!err) {
      var OrdensJSON = [];
      rows.forEach(function (row) {
        OrdensJSON.push({ "id": row.idCompra, "processado": row.processado });
      });

      res.send(JSON.stringify(OrdensJSON));
    }
    else {
      res.send("Erro");
    }
  })
});

// Arpovar ordem de compra
app.post('/aprovarOrdem', (req, res) => {
  con.query('UPDATE ordenscompra SET processado = 1 WHERE idCompra = ?', [req.body.id], (err) => {
    if (err) {
      console.log(err);
      res.send("Erro ao executar");
    }
    else {
      res.send("");
    }
  })
});

// COMPRAS
app.post('/compras', (req, res) => {
  con.query('SELECT * FROM ordenscompra;', (err, rows, fields) => {
    if (!err) {
      var OrdensJSON = [];
      rows.forEach(function (row) {
        OrdensJSON.push({ "codigo": row.idCompra, "produto": row.produto, "qtde": row.qtde });
      });

      res.send(JSON.stringify(OrdensJSON));
    }
    else {
      res.send("Erro");
    }
  })
});

app.post('/salvaCompra', (req, res) => {
  console.log(req);
  req.body.forEach(function (JSONdata){

    con.query('INSERT INTO ordenscompra (idCompra, produto, qtde, processado) VALUES ( ? , ? , ? , 0)', [Math.floor(Math.random() * 99999), JSONdata.produto, JSONdata.qtde], (err, rows, fields) => {
      if (err) {
        res.send("Erro");
      } else {
        res.send("");
      }
    })
  });
});
