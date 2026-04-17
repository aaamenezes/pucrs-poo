package dados;

public class Corporativo extends Cliente {
    private String cnpj;
    private String nomeFantasia;

    public Corporativo(String nome, String email, String cnpj, String nomeFantasia) {
        super(nome, email);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }
}
