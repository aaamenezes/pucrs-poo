package dados;

public class Individual extends Cliente {
    private String cpf;

    public Individual(String name, String email, String cpf) {
        super(name, email);
        this.cpf = cpf;
    }
}
