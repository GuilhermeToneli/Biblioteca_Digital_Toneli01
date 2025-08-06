package com.unifecaf.biblioteca.service;

import com.unifecaf.biblioteca.model.Livro;
import com.unifecaf.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Anotação que define a classe como um serviço Spring
public class LivroService {

    @Autowired // Injeção de dependência do repositório
    private LivroRepository livroRepository;

    // CREATE: Salva um novo livro
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    // READ: Retorna todos os livros
    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }



    // READ: Retorna um livro pelo ID
    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    // UPDATE: Atualiza um livro existente
    public Livro atualizar(Long id, Livro livroAtualizado) {
        return livroRepository.findById(id)
                .map(livro -> {
                    livro.setTitulo(livroAtualizado.getTitulo());
                    livro.setAutor(livroAtualizado.getAutor());
                    livro.setIsbn(livroAtualizado.getIsbn());
                    livro.setEditora(livroAtualizado.getEditora());
                    livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
                    return livroRepository.save(livro);
                }).orElseThrow(() -> new RuntimeException("Livro não encontrado com o id " + id));
    }

    // DELETE: Deleta um livro pelo ID
    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}