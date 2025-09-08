package application.elenco.artista;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import application.elenco.funcao.Funcao;

public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepo;
    @Autowired
    private FuncaoService funcaoService;

    public Iterable<ArtistaDTO> getAll() {
        return artistaRepo.findAll().stream().map(ArtistaDTO::new).toList();
    }

    public ArtistaDTO insert(ArtistaInsertDTO novoArtista) {
        Funcao funcao = new Funcao(funcaoService.getOne(novoArtista.idGenero()));

        Artista artista = new Artista();
        artista.setNome(novoArtista.nome());
        artista.setFuncao(funcao);

        return new ArtistaDTO(artista);
    }

    public ArtistaDTO getOne(Long id) {
        Optional<Artista> resultado = artistaRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Artista nao encontrado"
            );
        }

        return new ArtistaDTO(resultado.get());
    }

    public ArtistaDTO update(long id, ArtistaInsertDTO novosDados) {
        Optional<Artista> resultado = artistaRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Artista nao encontrado"
            );
        }

        Funcao funcao = new Funcao(funcaoService.getOne(novosDados.idGenero()));

        resultado.get().setNome(novosDados.nome());
        resultado.get().setFuncao(funcao);

        return new ArtistaDTO(artistaRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!artistaRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Artista nao encontrado"
            );
        }

        artistaRepo.deleteById(id);
    }
