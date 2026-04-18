package dados;

public enum Categoria {
    ADVENTURE("Aventura"),
    STRATEGY("Estratégia"),
    RACING("Corrida");

    private String description;

    private Categoria(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
