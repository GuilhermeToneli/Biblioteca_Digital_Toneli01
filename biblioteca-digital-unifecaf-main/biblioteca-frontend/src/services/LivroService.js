import axios from 'axios';

// URL base da nossa API. O back-end está rodando na porta 8080.
const API_URL = 'http://localhost:8080/api/livros';

// Função para buscar todos os livros
const getAll = () => {
    return axios.get(API_URL);
};

// Função para buscar um livro por ID
const getById = (id) => {
    return axios.get(`${API_URL}/${id}`);
};

// Função para criar um novo livro
const create = (livro) => {
    return axios.post(API_URL, livro);
};

// Função para atualizar um livro
const update = (id, livro) => {
    return axios.put(`${API_URL}/${id}`, livro);
};

// Função para deletar um livro
const remove = (id) => {
    return axios.delete(`${API_URL}/${id}`);
};

const LivroService = {
    getAll,
    getById,
    create,
    update,
    remove
};

export default LivroService;