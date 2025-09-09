package application.elenco;

import application.filmes.FilmeDTO;
import application.elenco.artista.ArtistaDTO;
import application.elenco.funcao.FuncaoDTO;

public record ElencoDTO(long id, FilmeDTO filme, ArtistaDTO artista, FuncaoDTO funcao) {
    ElencoDTO(Elenco dados) {
        this(dados.getId(), 
        new FilmeDTO(dados.getFilme()), 
        new ArtistaDTO(dados.getArtista()), 
        new FuncaoDTO(dados.getFuncao()));
    }
}
