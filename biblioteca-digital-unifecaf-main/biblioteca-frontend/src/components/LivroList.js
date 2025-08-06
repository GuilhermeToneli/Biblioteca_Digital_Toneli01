import React, { useState, useEffect } from 'react';
import LivroService from '../services/LivroService';
import LivroForm from './LivroForm';

function LivroList() {
    const [livros, setLivros] = useState([]);
    const [livroAtual, setLivroAtual] = useState(null); // Para edição

    // Carrega os livros da API quando o componente é montado
    useEffect(() => {
        carregarLivros();
    }, []);

    const carregarLivros = () => {
        LivroService.getAll()
            .then(response => {
                setLivros(response.data);
            })
            .catch(error => console.error("Ocorreu um erro ao carregar os livros!", error));
    };

    const handleSave = (livro) => {
        const promise = livro.id 
            ? LivroService.update(livro.id, livro) 
            : LivroService.create(livro);
            
        promise.then(() => {
            carregarLivros(); // Recarrega a lista
            setLivroAtual(null); // Limpa o formulário
        }).catch(error => console.error("Ocorreu um erro ao salvar o livro!", error));
    };

    const handleEdit = (livro) => {
        setLivroAtual(livro);
    };

    const handleDelete = (id) => {
        LivroService.remove(id)
            .then(() => {
                carregarLivros(); // Recarrega a lista após a exclusão
            })
            .catch(error => console.error("Ocorreu um erro ao deletar o livro!", error));
    };

    return (
        <div>
            <h1>Biblioteca Digital - Gestão de Livros</h1>
            <LivroForm livroAtual={livroAtual} onSave={handleSave} />
            <h2>Acervo</h2>
            <table border="1" style={{ width: '100%', borderCollapse: 'collapse' }}>
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Autor</th>
                        <th>ISBN</th>
                        <th>Ano</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {livros.map(livro => (
                        <tr key={livro.id}>
                            <td>{livro.titulo}</td>
                            <td>{livro.autor}</td>
                            <td>{livro.isbn}</td>
                            <td>{livro.anoPublicacao}</td>
                            <td>
                                <button onClick={() => handleEdit(livro)}>Editar</button>
                                <button onClick={() => handleDelete(livro.id)}>Excluir</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default LivroList;