package application.elenco.funcao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FuncaoService {
    @Autowired
    private FuncaoRepository funcaoRepo;

    public Iterable<FuncaoDTO> getAll() {
        return funcaoRepo.findAll().stream().map(FuncaoDTO::new).toList();
    }

    public FuncaoDTO insert(FuncaoInsertDTO novaFuncao) {

        Funcao funcao = new Funcao();
        funcao.setDescricao(novaFuncao.descricao());

        return new FuncaoDTO(funcaoRepo.save(funcao));
    }

    public FuncaoDTO getOne(Long id) {
        Optional<Funcao> resultado = funcaoRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Funcao nao encontrada"
            );
        }

        return new FuncaoDTO(resultado.get());
    }

    public FuncaoDTO update(long id, FuncaoInsertDTO novosDados) {
        Optional<Funcao> resultado = funcaoRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Funcao nao encontrada"
            );
        }

        resultado.get().setDescricao(novosDados.descricao());

        return new FuncaoDTO(funcaoRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!funcaoRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Funcao nao encontrada"
            );
        }

        funcaoRepo.deleteById(id);
    }
}
