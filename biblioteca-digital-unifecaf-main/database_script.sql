-- Script para criar a tabela 'livro' no PostgreSQL

CREATE TABLE livro (
    id BIGSERIAL PRIMARY KEY,  -- BIGSERIAL é um tipo auto-incrementável no PostgreSQL
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    editora VARCHAR(100),
    ano_publicacao INT NOT NULL
);