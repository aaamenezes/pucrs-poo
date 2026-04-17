package dados;

public class Individual extends Cliente {
    private String cpf;

    public Individual(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }
}
