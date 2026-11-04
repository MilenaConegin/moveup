Deploy
A aplicação está hospedada no Render:

https://moveup-89cd.onrender.com

MoveUp
Sobre o projeto
O MoveUp é uma solução que busca incentivar a mobilidade urbana sustentável por meio da tecnologia. A proposta é estimular o uso de transportes coletivos e outras alternativas de deslocamento sustentáveis, permitindo que os usuários acumulem pontos e tenham acesso a benefícios.

A plataforma contempla o gerenciamento de usuários, vouchers e histórico de atividades.
Funcionalidades
- Usuários: cadastro, consulta, atualização e exclusão.
- Vouchers: cadastro e gerenciamento de cartões/vouchers, incluindo tipo, status e saldo disponível.
- Histórico: registro e consulta de atividades, com data, meio de transporte, quantidade de passagens, pontos e status.
- Validações: verificações dos dados recebidos pela API, como e-mail, senha, datas, status e valores não negativos.
Tecnologias utilizadas
- Java 21 — linguagem de desenvolvimento.
- Spring Boot — estrutura da aplicação e criação dos endpoints REST.
- Spring Web MVC — exposição dos recursos HTTP.
- Bean Validation — validação dos dados recebidos.
- JDBC — comunicação com o banco de dados.
- Oracle Database — banco de dados relacional.
- Maven — gerenciamento de dependências e build.
- Docker — configuração de empacotamento e execução em contêiner.
- Render — hospedagem do serviço.

## Estrutura do projeto

A aplicação segue uma organização em camadas:

```text
src/
└── main/
    ├── java/
    │   └── br/
    │       └── com/
    │           └── fiap/
    │               ├── bo/          # Regras de negócio e validações
    │               ├── dao/         # Acesso e operações no banco de dados
    │               ├── resource/    # Endpoints REST da API
    │               ├── to/          # Objetos de transferência de dados
    │               └── MoveupApplication.java
    └── resources/
        └── application.properties
```
- Resource: recebe as requisições HTTP e retorna as respostas.
- BO (Business Object): concentra regras de negócio e validações.
- DAO (Data Access Object): executa operações de persistência no banco de dados.
- TO (Transfer Object): transporta os dados entre as camadas.

Endpoints da API
A URL-base da API é:
https://moveup-89cd.onrender.com
Recurso	Método	Endpoint	Descrição
Usuário	POST	/moveup/usuario	Cadastrar usuário
Usuário	GET	/moveup/usuario	Listar usuários
Usuário	GET	/moveup/usuario/{idUsuario}	Consultar usuário por ID
Usuário	PUT	/moveup/usuario/{idUsuario}	Atualizar usuário
Usuário	DELETE	/moveup/usuario/{idUsuario}	Excluir usuário
Voucher	POST	/moveup/voucher	Cadastrar voucher
Voucher	GET	/moveup/voucher	Listar vouchers
Voucher	GET	/moveup/voucher/{cdCartao}	Consultar voucher por código
Voucher	PUT	/moveup/voucher/{cdCartao}	Atualizar voucher
Voucher	DELETE	/moveup/voucher/{cdCartao}	Excluir voucher
Histórico	POST	/moveup/historico	Registrar histórico
Histórico	GET	/moveup/historico	Listar históricos
Histórico	GET	/moveup/historico/{idHistorico}	Consultar histórico por ID
Histórico	PUT	/moveup/historico/{idHistorico}	Atualizar histórico
Histórico	DELETE	/moveup/historico/{idHistorico}	Excluir histórico

Como executar localmente
Pré-requisitos
- JDK 21 ou superior;
- Maven (ou utilizar o Maven Wrapper incluído no projeto);
- Acesso a uma instância Oracle Database;
- Git.
1. Clone o repositório
git clone <URL_DO_REPOSITORIO>
cd moveup
2. Configure as variáveis de ambiente
A conexão com o banco de dados utiliza as seguintes variáveis de ambiente:
Variável	Descrição
DB_URL	URL JDBC de conexão com o Oracle
DB_USER	Usuário do banco de dados
DB_PASSWORD	Senha do banco de dados

Selecione o método POST.
Informe a URL https://moveup-89cd.onrender.com/moveup/usuario.
Acesse a aba Body.
Selecione JSON.

{
  "nomeUsuario": "Maria Silva",
  "email": "maria@email.com",
  "senha": "Senha@123_"
}

Cole o JSON acima.
Clique em Send

As configurações de ambiente necessárias para a conexão com o banco de dados devem estar definidas no serviço de hospedagem.
Objetivo

Promover escolhas de mobilidade mais sustentáveis por meio de uma experiência digital que conecta o uso do transporte coletivo à possibilidade de acumular pontos e acessar benefícios.
MoveUp — Mobilidade que gera benefícios.
