package com.unifecaf.biblioteca.repository;

import com.unifecaf.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Anotação que define a classe como um repositório Spring
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // JpaRepository<Livro, Long> já fornece métodos como:
    // save(), findById(), findAll(), deleteById(), etc.
    // Não precisamos escrever nenhuma implementação aqui.
}