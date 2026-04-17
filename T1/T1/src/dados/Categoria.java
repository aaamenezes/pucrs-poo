package dados;

public enum Categoria {
    AVENTURA("Aventura"),
    ESTRATEGIA("Estratégia"),
    CORRIDA("Corrida");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
