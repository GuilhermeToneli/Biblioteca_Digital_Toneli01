package com.unifecaf.biblioteca.controller;

import com.unifecaf.biblioteca.model.Livro;
import com.unifecaf.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta classe é um controlador REST
@RequestMapping("/api/livros") // Mapeia todas as requisições que começam com /api/livros para este controlador
@CrossOrigin(origins = "*") // Permite que requisições de qualquer origem (ex: front-end em localhost) acessem a API
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Endpoint para CRIAR um novo livro (CREATE) 
    @PostMapping
    public ResponseEntity<Livro> criarLivro(@Valid @RequestBody Livro livro) {
        Livro novoLivro = livroService.salvar(livro);
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }

    // Endpoint para CONSULTAR todos os livros (READ) 
    @GetMapping
    public List<Livro> listarTodosLivros() {
        return livroService.buscarTodos();
    }

    // Endpoint para CONSULTAR um livro por ID (READ) 
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para ATUALIZAR um livro (UPDATE) 
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @Valid @RequestBody Livro livro) {
        Livro livroAtualizado = livroService.atualizar(id, livro);
        return ResponseEntity.ok(livroAtualizado);
    }

    // Endpoint para DELETAR um livro (DELETE) 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}