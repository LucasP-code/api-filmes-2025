package application.elenco.artista;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepo;

    public Iterable<ArtistaDTO> getAll() {
        return artistaRepo.findAll().stream().map(ArtistaDTO::new).toList();
    }

    public ArtistaDTO insert(ArtistaInsertDTO novoArtista) {

        Artista artista = new Artista();
        artista.setNome(novoArtista.nome());

        return new ArtistaDTO(artistaRepo.save(artista));
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

        resultado.get().setNome(novosDados.nome());

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
}
