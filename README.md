# Sistema ERP Java

Bem-vindo(a) ao meu sistema ERP feito em Java!

Esta aplicação permite que você realize operações como cadastrar produtos, adicionando o nome do produto, cor, modelo e controlar o estoque desses produtos cadastrados.


### Linguagem utilizada

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

## Como usar

1. Cadastrando produtos: Ao iniciar a aplicação selecione a opção 1 e siga as instruções na tela, adicionando o nome do produto, cor, modelo e estoque

2. Consultando produtos: Selecionando a opção 2 ou 3 no menu inicial, o usuário consegue ver a lista de todos os produtos cadastrados e selecionar um produto especifico

3. Menu Estoque: Ao selecionar a opção 4, o usuário é levado até o sistema de estoque dos produtos cadastrados.

4. Modificando o estoque dos produtos: No menu estoque, selecionado a opção 1 ou 3 o usuário consegue selecionar um produto especifico pelo código gerado pelo sistema e modificar ou zerar, respectivamente, o estoque total do produto selecionado

5. Consultando o estoque atual do produto: No menu estoque, selecionado a opção 2 o usuário consegue selecionar um produto e o sistema mostra o estoque total do produto

6. Voltando ao menu principal: Selecionando a opção 4 no menu estoque, o usuário é transportado ao menu principal onde consegue cadastrar e consultar produtos


## Estrutura do Projeto

FuncoesPai: Contém os métodos comuns que são compartilhados entre Produto e Estoque.

Sistema: Contém a classe Main que inicia o programa e interage com o usuário

Produto: Contém todas as funções relacionadas ao menu principal, onde é possivel cadastrar, consultar e selecionar produtos. Além de ir ao menu estoque.

Estoque: Contém todas as funções relacionadas ao menu estoque, onde é possivel modificar, consultar e zerar o estoque dos produtos.

## Licença

Este projeto está licenciado sob a [MIT License] https://github.com/dev-aguiar/sistema-erp/blob/main/LICENSE.
