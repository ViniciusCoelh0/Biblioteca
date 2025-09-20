
# 📚 Sistema de Gerenciamento de Biblioteca

Este é um simples sistema de gerenciamento de biblioteca desenvolvido em Java. A aplicação funciona via console (terminal) e permite ao usuário realizar operações básicas de cadastro, consulta, atualização e remoção de livros. Os dados são armazenados de forma persistente em um banco de dados SQLite.

## ✨ Funcionalidades

O sistema oferece um menu interativo com as seguintes funcionalidades:

- **Adicionar Livro:** Insere um novo livro no banco de dados, solicitando título, autor e ano de publicação.
    
- **Listar Livros:** Exibe todos os livros atualmente cadastrados no acervo.
    
- **Buscar Livro:** Procura por um livro específico a partir do título ou do nome do autor.
    
- **Atualizar Livro:** Permite modificar os dados (título, autor e ano) de um livro já existente.
    
- **Remover Livro:** Exclui um livro do banco de dados a partir do seu título.
    

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java
    
- **Banco de Dados:** SQLite
    
- **Driver JDBC:** para a comunicação com o banco de dados.
    

## 📁 Estrutura do Projeto

O código-fonte está organizado nos seguintes pacotes:

- `main/java/`: Contém a classe principal que inicia a aplicação.
    
    - `Main.java`: Ponto de entrada do programa. Responsável pelo menu e pela interação com o usuário.
        
- `db/`: Classes responsáveis pela interação com o banco de dados.
    
    - `DatabaseService.java`: Gerencia a conexão com o banco de dados `biblioteca.db`.
        
    - `DatabaseSetup.java`: Cria a tabela `livros` caso ela ainda não exista.
        
    - `LivroDAO.java`: Contém os métodos para manipulação dos dados dos livros (CRUD - Criar, Ler, Atualizar, Deletar).
        
- `entities/`: Classes que representam os objetos do sistema.
    
    - `Livro.java`: Representa a entidade Livro, com seus atributos (título, autor, ano).
        
    - `Biblioteca.java`: (Classe não utilizada na versão com banco de dados) Uma implementação inicial que gerenciava os livros em memória.
        

## 🚀 Como Executar o Projeto

Para executar este projeto, você precisará ter o instalado e o driver JDBC do SQLite.

1. **Baixe o Driver JDBC do SQLite:** Faça o download do arquivo `.jar` .
	1. Link do projeto [https://github.com/xerial/sqlite-jdbc/releases]
	2. Baixe o arquivo com o seguinte nome "[sqlite-jdbc-3.50.3.0.jar](https://github.com/xerial/sqlite-jdbc/releases/download/3.50.3.0/sqlite-jdbc-3.50.3.0.jar)"
    
2. **Clone o repositório:**
	1. git clone https://github.com/ViniciusCoelh0/Biblioteca.git
    
3. **Acesse o diretório do projeto:**
	1. cd Biblioteca
    
4. **Organize os arquivos:**
    
    - Crie um diretório `lib` na raiz do projeto e coloque o arquivo `.jar` do SQLite JDBC que você baixou.
        
    - Crie um diretório `out` para os arquivos compilados.
        
    - Certifique-se de que seu código-fonte esteja em um diretório como `src/`.
        
    
    A estrutura deve ficar parecida com:
    
		- main/java/: Contém a classe principal que inicia a aplicação.
		    
		    - Main.java: Ponto de entrada do programa. Responsável pelo menu e pela interação com o usuário.
		        
		- db/: Classes responsáveis pela interação com o banco de dados.
		    
		    - DatabaseService.java: Gerencia a conexão com o banco de dados `biblioteca.db`.
		        
		    - DatabaseSetup.java: Cria a tabela `livros` caso ela ainda não exista.
		        
		    - LivroDAO.java: Contém os métodos para manipulação dos dados dos livros (CRUD - Criar, Ler, Atualizar, Deletar).
		        
		- entities/: Classes que representam os objetos do sistema.
		    
		    - Livro.java: Representa a entidade Livro, com seus atributos (título, autor, ano).
		        
		    - Biblioteca.java: (Classe não utilizada na versão com banco de dados) Uma implementação inicial que gerenciava os livros em memória.
    
5. **Compile o código:** Abra o terminal na raiz do projeto (`Biblioteca/`) e execute o comando de compilação. Ele irá compilar todos os arquivos `.java` do diretório `src` e colocar os `.class` no diretório `out`.
    
    _No Windows (usando `\` como separador):_
    
    _No Linux/macOS (usando `:` como separador):_
    
6. **Execute a aplicação
    Ao executar pela primeira vez, será criado um arquivo `biblioteca.db` na raiz do projeto.
    

## CONTRIBUTING 🤝 Como Contribuir

Contribuições são bem-vindas! Se você tiver ideias para novas funcionalidades ou melhorias, sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_.

1. Faça um _fork_ do projeto.
    
2. Crie uma nova _branch_ (`git checkout -b feature/nova-funcionalidade`).
    
3. Faça o _commit_ das suas alterações (`git commit -m 'Adiciona nova funcionalidade'`).
    
4. Envie para a sua _branch_ (`git push origin feature/nova-funcionalidade`).
    
5. Abra um _Pull Request_.
    

## 👨‍💻 Autor & Contato

Feito por Vinícius Coelho. 
Redes sociais:

<a href="https://www.linkedin.com/in/vinicius-dantas-coelho" target="_blank">LinkedIn</a>

<a href="https://www.instagram.com/ovinicius.dantas" target="_blank">Instagram</a>
## 📄 Licença

Este projeto está sob a licença MIT. 
