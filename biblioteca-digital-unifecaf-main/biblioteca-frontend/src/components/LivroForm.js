import React, { useState, useEffect } from 'react';
import LivroService from '../services/LivroService';

function LivroForm({ livroAtual, onSave }) {
    const [livro, setLivro] = useState({
        titulo: '',
        autor: '',
        isbn: '',
        editora: '',
        anoPublicacao: ''
    });

    useEffect(() => {
        if (livroAtual) {
            setLivro(livroAtual);
        } else {
            // Limpa o formulário se não houver livro para editar
             setLivro({ titulo: '', autor: '', isbn: '', editora: '', anoPublicacao: '' });
        }
    }, [livroAtual]);

    const handleChange = (event) => {
        const { name, value } = event.target;
        setLivro({ ...livro, [name]: value });
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        onSave(livro); // A função onSave será responsável por criar ou atualizar
    };

    return (
        <form onSubmit={handleSubmit} style={{ marginBottom: '20px' }}>
            <h3>{livro.id ? 'Editar Livro' : 'Adicionar Novo Livro'}</h3>
            <input
                type="text"
                name="titulo"
                placeholder="Título"
                value={livro.titulo}
                onChange={handleChange}
                required
            />
            <input
                type="text"
                name="autor"
                placeholder="Autor"
                value={livro.autor}
                onChange={handleChange}
                required
            />
            <input
                type="text"
                name="isbn"
                placeholder="ISBN"
                value={livro.isbn}
                onChange={handleChange}
                required
            />
            <input
                type="text"
                name="editora"
                placeholder="Editora"
                value={livro.editora}
                onChange={handleChange}
            />
            <input
                type="number"
                name="anoPublicacao"
                placeholder="Ano de Publicação"
                value={livro.anoPublicacao}
                onChange={handleChange}
                required
            />
            <button type="submit">{livro.id ? 'Atualizar' : 'Salvar'}</button>
        </form>
    );
}

export default LivroForm;