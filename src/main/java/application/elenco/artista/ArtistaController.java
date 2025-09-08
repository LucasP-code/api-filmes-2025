package application.elenco.artista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    @Autowired
    ArtistaService artistaService;

    @GetMapping
    public Iterable<ArtistaDTO> getAll() {
        return this.artistaService.getAll();
    }

    @PostMapping
    public ArtistaDTO insert(@RequestBody ArtistaInsertDTO novosDados) {
        return this.artistaService.insert(novosDados);
    }

    @PutMapping("/{id}")
    public ArtistaDTO update(@PathVariable Long id, @RequestBody ArtistaInsertDTO dados) {
        return this.artistaService.update(id, dados);
    }

    @GetMapping("/{id}")
    public ArtistaDTO getOne(@PathVariable Long id) {
        return this.artistaService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.artistaService.delete(id);
    }

}
