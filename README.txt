Avaliação A3 - Projeto Academia

Este projeto em Java foi desenvolvido no NetBeans e permite gerenciar *alunos* e seus *treinos* em um banco de dados MySQL, seguindo o padrão DAO (Data Access Object).

> Visão Geral

- *Entidades*  
  - alunos.java — classe que representa um aluno (ID, nome, idade, email, telefone).  
  - treinos.java — classe que representa um treino (ID, aluno associado, tipo, duração, data).

- *DAO* 
  - alunosDAO.java — operações CRUD para a tabela alunos;  
  - treinosDAO.java — operações CRUD para a tabela treinos.

- *Conexão*  
  - MySQLConnection.java — utilitário para abrir/fechar conexão com o MySQL via JDBC.

- *Execução*  
  - ProjetoAcademia_A3.java — classe principal (main) que exibe um menu de console para gerenciar alunos e treinos.

> Pré-requisitos

1. *Java JDK 8+* instalado e configurado no PATH; 
2. *NetBeans IDE* (ou outra IDE de sua preferência);  
3. *MySQL Server* rodando localmente ou remotamente;  
4. *Connector/J JDBC Driver* (mysql-connector-java-x.x.x.jar) adicionado às bibliotecas do projeto;

> Instalação e Configuração

1. *Clone ou importe* o projeto no NetBeans:
   - File → Open Project → selecione a pasta do projeto.

2. *Adicione o driver JDBC*:
   - Clique com o botão direito em *Libraries* → Add JAR/Folder → aponte para o "mysql-connector-java.jar".

3. *Use o Banco de Dados já criado (está no repositório do GitHub), baixe o arquivo e use o XAMPP para executá-lo.

OBS: Talvez o endereço do BD não seja o mesmo que no código, para resolver isso, abra a classe "MySQLConnection" no netbeans e mude a URL.

> Como usar

1. No NetBeans, clique com o botão direito em ProjetoAcademia_A3.java → Run File (ou use o atalho Shift+F6).

2. A janela de console irá exibir um menu como:

	=== MENU PRINCIPAL ===
	1) Cadastrar aluno
	2) Listar alunos
	3) Atualizar aluno
	4) Excluir aluno
	5) Cadastrar treino
	6) Listar treinos
	7) Atualizar treino
	8) Excluir treino
	9) Sair
	Escolha uma opção:

3. Digite o número da opção desejada e siga as instruções no console:

	- *Cadastrar/Atualizar*: insira dados como nome, idade, tipo de treino, data, etc.

	- *Listar*: exibe todos os registros no console.

	- *Excluir*: informe o ID do registro.
