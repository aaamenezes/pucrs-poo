package dados;

public abstract class Cliente {
    private int id;
    private String name;
    private String email;

    private static int counter = 0;

    public Cliente(String name, String email) {
        Cliente.counter++;
        this.id = Cliente.counter;
        this.name = name;
        this.email = email;
    }

    public String describe() {
        return this.id + ";" + this.name + ";" + this.email;
    }
}
