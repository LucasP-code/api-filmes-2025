package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.GeneroDTO;
import application.record.GeneroInsertDTO;
import application.service.GeneroService;

@RestController
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    private GeneroService generoService;
    
    @PostMapping
    public GeneroDTO insert(@RequestBody GeneroInsertDTO novoGenero){
        return generoService.insert(novoGenero);
    }

    @GetMapping("/{id}")
    public GeneroDTO getOne(@PathVariable long id) {
        return generoService.getOne(id);
    }

    @GetMapping
    public Iterable<GeneroDTO> getAll() {
        return generoService.getAll();
    }

    @PutMapping("/{id}")
    public GeneroDTO update(@PathVariable long id, @RequestBody GeneroInsertDTO dadosGenero) {
        return generoService.update(id, dadosGenero);
    }

    
    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        generoService.delete(id);
    }
}
