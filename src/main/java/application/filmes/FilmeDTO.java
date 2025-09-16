package application.filmes;

import java.util.Set;

import application.record.GeneroDTO;
import application.produtora.ProdutoraDTO;

public record FilmeDTO(long id, String titulo, GeneroDTO genero, Set<ProdutoraDTO> produtoras) {
    public FilmeDTO (Filme dados) {
        this(
            dados.getId(),
            dados.getTitulo(),
            new GeneroDTO(dados.getGenero()),
            dados.getProdutoras().stream().map(ProdutoraDTO::new).collect(java.util.stream.Collectors.toSet())
        );
    }
}
