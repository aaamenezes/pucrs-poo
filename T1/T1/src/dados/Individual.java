package dados;

public class Individual extends Cliente {
    private String cpf;

    public Individual(int numero, String nome, String email, String cpf) {
        super(numero, nome, email);
        this.cpf = cpf;
    }

    public String descrever() {
        return this.getNumero() + ";" + this.getNome() + ";" + this.getEmail();
    }
}
