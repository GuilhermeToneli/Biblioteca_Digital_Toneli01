import React from 'react';
import LivroList from './components/LivroList';
import './App.css'; // Você pode adicionar estilos básicos aqui

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <LivroList />
      </header>
    </div>
  );
}

export default App;