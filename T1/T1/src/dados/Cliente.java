package dados;

public abstract class Cliente {
    private int id;
    private String name;
    private String email;

    public Cliente(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String describe() {
        return this.id + ";" + this.name + ";" + this.email;
    }
}
