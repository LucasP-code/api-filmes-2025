package application.elenco;

public record FuncaoInsertDTO(String descricao) {
    public FuncaoInsertDTO(Funcao dados) {
        this(dados.getDescricao());
    }
}
