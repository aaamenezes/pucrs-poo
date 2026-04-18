package dados;

public abstract class Cliente {
    private int numero;
    private String nome;
    private String email;

    private static int contador = 0;

    public Cliente(String nome, String email) {
        Cliente.contador++;
        this.numero = Cliente.contador;
        this.nome = nome;
        this.email = email;
    }

    public String descrever() {
        return this.numero + ";" + this.nome + ";" + this.email;
    }
}
