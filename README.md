# ✈️ Agência de Viagens - Backend

Este é o projeto backend da aplicação "Agência de Viagens", construído com Spring Boot. Ele fornece uma API RESTful para gerenciar usuários, destinos de viagem e reservas, interagindo com um frontend desenvolvido em Angular.

## ✨ Funcionalidades

-   **Autenticação e Autorização**: Gerenciamento de usuários com JWT (JSON Web Tokens).
-   **Gerenciamento de Destinos**: Operações CRUD (Criar, Ler, Atualizar, Deletar) para destinos de viagem.
-   **Gerenciamento de Reservas**: Operações CRUD para reservas de viagem.
-   **Persistência de Dados**: Armazenamento de informações em um banco de dados MySQL.

## 🚀 Tecnologias Utilizadas

-   **Java 17**: Linguagem de programação.
-   **Spring Boot 3.x**: Framework para construção de aplicações Java.
-   **Spring Data JPA**: Para acesso a dados e ORM (Object-Relational Mapping).
-   **Spring Security**: Para autenticação e autorização.
-   **MySQL**: Banco de dados relacional.
-   **Maven**: Gerenciador de dependências e build.
-   **Lombok**: Para reduzir código boilerplate (getters, setters, construtores).
-   **JWT (JSON Web Tokens)**: Para autenticação stateless.

## 🛠️ Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

-   [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou superior.
-   [Apache Maven](https://maven.apache.org/download.cgi)
-   [MySQL Server](https://dev.mysql.com/downloads/mysql/) (versão 8.x recomendada)
-   Um cliente MySQL (ex: DBeaver, MySQL Workbench) para gerenciar o banco de dados.
-   O Frontend da Agência de Viagens (substitua pelo link do seu repositório frontend) para testar a integração.

## 🌐 Endpoints da API

A API expõe os seguintes endpoints:

### Autenticação (`/auth`)
-   `POST /auth/register`: Registra um novo usuário.
    -   **Body:** `{ "login": "string", "password": "string", "role": "ADMIN" | "USER" }`
    -   **Resposta:** `200 OK`
-   `POST /auth/login`: Autentica um usuário e retorna um JWT.
    -   **Body:** `{ "login": "string", "password": "string" }`
    -   **Resposta:** `200 OK`, `{ "token": "seu_jwt_aqui" }`

### Destinos (`/destinos`) - Requer JWT Válido
-   `GET /destinos`: Lista todos os destinos.
    -   **Resposta:** `200 OK`, `[ { "id": 1, "nome": "...", ... } ]`
-   `POST /destinos`: Cria um novo destino.
    -   **Body:** `{ "nome": "string", "descricao": "string", "preco": number, "duracaoDias": number }`
    -   **Resposta:** `201 Created`, `{ "id": 1, "nome": "...", ... }`
-   `GET /destinos/{id}`: Busca um destino pelo ID.
    -   **Resposta:** `200 OK`, `{ "id": 1, "nome": "...", ... }`
-   `PUT /destinos/{id}`: Atualiza um destino existente.
    -   **Body:** `{ "nome": "string", "descricao": "string", "preco": number, "duracaoDias": number }`
    -   **Resposta:** `200 OK`, `{ "id": 1, "nome": "...", ... }`
-   `DELETE /destinos/{id}`: Exclui um destino.
    -   **Resposta:** `204 No Content`

### Reservas (`/reservas`) - Requer JWT Válido
-   `GET /reservas`: Lista todas as reservas.
    -   **Resposta:** `200 OK`, `[ { "id": 1, "nomeCliente": "...", ... } ]`
-   `POST /reservas`: Cria uma nova reserva.
    -   **Body:** `{ "destino": { "id": number }, "nomeCliente": "string", "email": "string", "dataPartida": "yyyy-MM-dd", "dataRetorno": "yyyy-MM-dd", "quantidadePessoas": number }`
    -   **Resposta:** `201 Created`, `{ "id": 1, "nomeCliente": "...", ... }`
-   `GET /reservas/{id}`: Busca uma reserva pelo ID.
    -   **Resposta:** `200 OK`, `{ "id": 1, "nomeCliente": "...", ... }`
-   `PUT /reservas/{id}`: Atualiza uma reserva existente.
    -   **Body:** `{ "destino": { "id": number }, "nomeCliente": "string", "email": "string", "dataPartida": "yyyy-MM-dd", "dataRetorno": "yyyy-MM-dd", "quantidadePessoas": number, "status": "string" }`
    -   **Resposta:** `200 OK`, `{ "id": 1, "nomeCliente": "...", ... }`
-   `DELETE /reservas/{id}`: Exclui uma reserva.
    -   **Resposta:** `204 No Content`

  ## 🔒 Autenticação (JWT)
  
  - A API utiliza JSON Web Tokens (JWT) para proteger os endpoints. Para acessar as rotas protegidas, um token JWT válido deve ser incluído no cabeçalho Authorization da requisição, no formato Bearer SEU_TOKEN_AQUI.
  
  🤝 Contribuição: Sinta-se à vontade para abrir issues ou enviar pull requests para melhorias.


  👩🏻‍💻 Projeto desenvolvido por Maria Aline Mees, como parte dos estudos durante o curso +Devs2Blu! 💙


    
