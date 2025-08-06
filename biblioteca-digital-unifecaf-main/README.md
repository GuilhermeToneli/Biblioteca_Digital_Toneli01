# Biblioteca Digital: Sistema Integrado de Gestão de Livros

## 1. Descrição do Projeto

[cite_start]Este projeto foi desenvolvido como solução para o estudo de caso da UniFECAF. [cite_start]O objetivo é criar um sistema de gerenciamento para uma biblioteca municipal, modernizando suas operações. [cite_start]O sistema permite a administração eficaz do acervo de livros, com funcionalidades para cadastrar novos títulos, consultar, atualizar e deletar livros existentes (CRUD).

## 2. Tecnologias Utilizadas

O sistema foi construído com uma arquitetura de três camadas, utilizando as seguintes tecnologias:

* [cite_start]**Back-end:** 
    * Java 24
    * [cite_start]Spring Boot 3 
    * Spring Data JPA
    * Gradle
* [cite_start]**Front-end:** 
    * React 18
    * Axios (para requisições HTTP)
    * HTML/CSS
* [cite_start]**Banco de Dados:** 
    * [cite_start]PostgreSQL 

## 3. Pré-requisitos

Antes de começar, você precisará ter as seguintes ferramentas instaladas em seu ambiente:
* Java JDK (versão 17 ou superior)
* Node.js e npm
* Git
* PostgreSQL

## 4. Como Executar o Projeto

Siga os passos abaixo para executar o sistema em seu ambiente local.

### Passo 1: Clone o Repositório

```bash
git clone https://github.com/GoOrdinho10/biblioteca-digital-unifecaf.git
cd biblioteca-digital-unifecaf
```

### Passo 2: Configure o Banco de Dados

1.  Certifique-se de que seu SGBD PostgreSQL está em execução.
2.  Usando uma ferramenta como o pgAdmin, crie um novo banco de dados. O nome utilizado na configuração padrão é `biblioteca_db`.
    ```sql
    CREATE DATABASE biblioteca_db;
    ```
3.  Execute o script SQL (disponível neste repositório como `database_script.sql`) para criar a tabela `livro`.

### Passo 3: Execute o Back-end

1.  Navegue até a pasta do back-end (a pasta `biblioteca`).
2.  Abra o arquivo `src/main/resources/application.properties`.
3.  **Importante:** Altere as propriedades `spring.datasource.username` e `spring.datasource.password` com as suas credenciais do PostgreSQL.
4.  Execute o seguinte comando no terminal para iniciar a aplicação Spring Boot:
    ```bash
    ./gradlew bootRun
    ```
5.  O servidor back-end estará rodando em `http://localhost:8080`. Mantenha este terminal aberto.

### Passo 4: Execute o Front-end

1.  Em um novo terminal, navegue até a pasta do front-end (a pasta `biblioteca-frontend`).
2.  Instale as dependências do projeto com o npm:
    ```bash
    npm install
    ```
3.  Inicie o servidor de desenvolvimento do React:
    ```bash
    npm start
    ```
4.  A aplicação será aberta automaticamente no seu navegador em `http://localhost:3000`.

## 5. Endpoints da API

A API do back-end expõe os seguintes endpoints para as operações de CRUD:

| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/livros` | Cadastra um novo livro. |
| `GET` | `/api/livros` | Retorna a lista de todos os livros. |
| `GET` | `/api/livros/{id}` | Retorna um livro específico pelo ID. |
| `PUT` | `/api/livros/{id}` | Atualiza um livro existente. |
| `DELETE` | `/api/livros/{id}` | Deleta um livro pelo ID. |
