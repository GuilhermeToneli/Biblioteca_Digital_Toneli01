package com.unifecaf.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // Anotação que indica que esta classe é uma entidade JPA
public class Livro {

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco de dados gerará o ID automaticamente
    private Long id;

    @NotBlank(message = "O título não pode estar em branco.") // Validação: não pode ser nulo ou vazio
    @Size(min = 2, max = 100, message = "O título deve ter entre 2 e 100 caracteres.")
    private String titulo;

    @NotBlank(message = "O autor não pode estar em branco.")
    @Size(min = 2, max = 100, message = "O nome do autor deve ter entre 2 e 100 caracteres.")
    private String autor;

    @NotBlank(message = "O ISBN não pode estar em branco.")
    @Size(min = 10, max = 13, message = "O ISBN deve ter entre 10 e 13 caracteres.")
    private String isbn;

    private String editora;

    @NotNull(message = "O ano de publicação não pode ser nulo.")
    private Integer anoPublicacao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}