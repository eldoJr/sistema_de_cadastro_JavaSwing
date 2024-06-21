Documentação do Sistema de Vendas - Versão 1.0

1. Introdução
Bem-vindo à documentação do Sistema de Vendas de registo de Automoveis! Este sistema foi desenvolvido para gerenciar informações de vendas, proporcionando uma maneira fácil e eficaz de cadastrar, visualizar, editar e excluir dados de vendas.

2. Instalação
Antes de iniciar a instalação, certifique-se de que seu sistema atende aos seguintes requisitos:

Java JDK 8 ou superior
Maven
MySQL Server
2.1. Passos de Instalação
Clone o repositório do sistema: git clone https://github.com/eldodev/sistema-vendas.git
Acesse o diretório do sistema: cd sistema-vendas
Execute o comando Maven para compilar e empacotar o sistema: mvn clean package
Importe o script SQL fornecido (script.sql) para criar o banco de dados.
Execute o sistema: java -jar target/sistema-vendas.jar

3.Configuração
No arquivo config.properties, você deve configurar as informações relacionadas ao banco de dados, como URL, usuário e senha.

# Configurações do Banco de Dados
db.url=jdbc:mysql://localhost:3306/dbregistarvendas
db.user= "root"
db.password= ""

4. Funcionalidades Principais
4.1. Cadastro de Vendas
Para cadastrar uma nova venda, siga os passos abaixo:

Abra a interface de cadastro.
Preencha todos os campos obrigatórios (cliente, cor, modelo, veículo, ano de fabrico, preço).
Clique no botão "Salvar".
4.2. Visualização de Dados
Acesse a interface principal para visualizar a tabela de vendas.
Os dados da tabela são atualizados automaticamente ao cadastrar uma nova venda.
4.3. Edição de Dados
Selecione a célula que deseja editar na tabela.
Clique com o botão direito e escolha "Editar".
Insira o novo valor e confirme.
4.4. Exclusão de Dados
Selecione a linha da tabela que deseja excluir.
Clique com o botão direito e escolha "Excluir".
Confirme a exclusão.

5. Banco de Dados
A estrutura do banco de dados é composta por uma tabela principal: vendas.