package application.record;

import application.model.Genero;

public record GeneroInsertDTO(String nome)  {
    public GeneroInsertDTO(Genero dados){
        this(dados.getNome());
    }

}
