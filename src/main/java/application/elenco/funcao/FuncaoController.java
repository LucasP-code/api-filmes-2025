package application.elenco.funcao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcoes")
public class FuncaoController {
    @Autowired
    FuncaoService funcaoService;

    @GetMapping
    public Iterable<FuncaoDTO> getAll() {
        return this.funcaoService.getAll();
    }

    @PostMapping
    public FuncaoDTO insert(@RequestBody FuncaoInsertDTO novosDados) {
        return this.funcaoService.insert(novosDados);
    }

    @PutMapping("/{id}")
    public FuncaoDTO update(@PathVariable Long id, @RequestBody FuncaoInsertDTO dados) {
        return this.funcaoService.update(id, dados);
    }

    @GetMapping("/{id}")
    public FuncaoDTO getOne(@PathVariable Long id) {
        return this.funcaoService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.funcaoService.delete(id);
    }

}
