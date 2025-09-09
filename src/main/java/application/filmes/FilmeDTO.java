package application.filmes;

import application.record.GeneroDTO;

public record FilmeDTO(long id, String titulo, GeneroDTO genero){
    public FilmeDTO (Filme dados) {
        this(dados.getId(), dados.getTitulo(), new GeneroDTO(dados.getGenero()));
    }
}
