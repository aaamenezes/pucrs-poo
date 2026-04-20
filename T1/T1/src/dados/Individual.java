package dados;

public class Individual extends Cliente {
    private String cpf;

    public Individual(int id, String name, String email, String cpf) {
        super(id, name, email);
        this.cpf = cpf;
    }
}
