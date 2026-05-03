package dados;

public class Corporativo extends Cliente {
    private final String cnpj;
    private String nomeFantasia;

    public Corporativo(int numero, String nome, String email, String cnpj, String nomeFantasia) {
        super(numero, nome, email);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public String descrever() {
        return this.getNumero() + ";" + this.getNome() + ";" + this.getEmail();
    }

    public String getDocumento() {
        return this.cnpj;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }
}
