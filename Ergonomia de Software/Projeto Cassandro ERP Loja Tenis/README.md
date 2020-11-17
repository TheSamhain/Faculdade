# ERPLojaTenis

# PROJETO VENDAS 

DOCUMENTO 0001  
MARCELO  TADEU CARVALHO NASCIMENTO  
RUI VELASQUE TEIXEIRA JÚNIOR  
ÚLTIMA ATUALIZAÇÃO: 25/05/2020  

## INTRODUÇÃO 
O objetivo deste projeto e desenvolver um software de controle de estoque e vendas em uma loja de tênis onde o almoxarifado informara os produtos em falta ao setor de compras que entrara em contato com financeiro decidindo assim oque será comprado ou não.

O sistema apresenta falhas em seu banco de dados em questão de controle de estoque sendo assim o foco será minimizar estes problemas e atender o cliente da melhor formula possível. 

## OBJETIVO
Temos em mente como objetivo principal a modernização do controle de estoque onde apresentaremos um sistema simples mas eficaz com isso o usuário encontrara praticidade na hora que estiver trabalhando com ele.

## CARACTERÍSTICAS GERAIS
O sistema ira operar com um servidor que gerencia o banco de dados e controla o cadastro de cada item devidamente cadastrado no sistema.

    - O sistema será executado em uma plataforma web.
    - Não alterar as restrições impostas no projeto.
    - Melhoria do processo se achar necessário mas não alterando a ideia principal .
    - Restrições

O sistema não permitirá o cadastro de produtos que não contam no sistema ou compra de produtos não autorizada pelo financeiro.

## CARACTERÍSTICAS TÉCNICAS
    - MySQL plataforma Windows(2).
    - Servidor Web em plataforma Windows.
    - Os coletores deverão ser baseados em plataforma Windows.

## ESCOPO DE TELAS OPERACIONAIS 
### 1-Estrutura base
     
#### Característica frame principal:
    - Pagina oculta para divisão de tela
    - Divisão em 4 partes Cabeçalho(14%),Rodapé(0%),Areá Principal(86%)
#### Característica Cabeçalho:
    - Subdividido em 4 partes 
    - Menu
    - Logotipo
    - Pagina Selecionada
    - Dados empresárias
#### Característica Rodapé:
    - Nome da empresa e informações de usuário.

### 2-Login de Acesso 

Objetivo: Evitar a entrada de terceiros no sistema da empresa.

#### Característica de Usuário
    - Solicitara apenas usuário e senha.
    - Validações de Usuário
    - Será autorizado apenas usuários já cadastrados 

### 3-Menu
Objetivo: O menu tem como objetivo demonstrar as funções dentro da empresa onde todos compartilharam de um mesmo ambiente independente da função mas trabalhara somente com sua função.

#### Características
    - O menu demonstrara ícones representativos de cada setor.
    - Assim sendo dividido em colunas.

### 4-Associação de Código de Barras 
Objetivo: Tem como objetivo cadastrar os produtos da empresa.

#### Campos da Tela:
    - Código do Produto
    - Descrição do produto
    - Foto do Produto
#### Campos do Produto
    - Código do produto
    - Nome do produto
    - Informações do Produto
    - Data de Emissão 
#### Características 
    - A tela devera informa o código de barras tanto externo quanto interno e informações do produto.
    - O cliente final não deve saber o código interno.
    - A pesquisa do produto deve ser realizada pelo nome ou código de barras.
    - A etiqueta deve conter informações do produto.
    - O código deve conter no máximo 4 dígitos.

### 5-Conferencia de Produtos
Objetivo: Conferir se os produtos foram cadastrados corretamente.

#### Campos da tela
    - Apresentara os dados do produto informando se foi cadastrado corretamente.


## ALMOXARIFADO 
Objetivo: O almoxarifado tem como objetivo analisar as tabelas do banco de dados e informar ao setor de compras os pedidos a serem feitos.

### Campos da tela
A tela de usuário devera conter as planilhas e os dados de cada produto, como a quantidade em estoque. Em outra aba ele tera a opção de cadastrar novos produtos e excluir produtos que não serão mais vendidos.

### Banco de dados
    - Planilhas demonstrando o estoque de cada produto
    - Cadastro de Produtos

### Características 
    - Informa ao setor de compras os pedidos necessários
    - Controlar o estoque
    - Analisar as Planilhas

## SETOR DE COMPRAS
Objetivo: Entrar em contato com o setor de almoxarifado imprimir um relatório de produtos em falta e demonstrar ao financeiro o pedido que deve ser feito.

### Características
    - Entrar em conato com os vendedores 
    - Realizar os Pedidos feitos pelo almoxarifado
    - Repassar Lista de compras ao financeiro 


## FINANCEIRO 
Objetivo: O financeiro tem como objetivo liderar os outros setores e autorizar os pedidos de compras.

### Características
    - Autorizar Pedidos
    - Controlar os outros setores
    - Realizar o pagamento dos pedidos
