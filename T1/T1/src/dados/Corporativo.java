package dados;

public class Corporativo extends Cliente {
    private String cnpj;
    private String businessName;

    public Corporativo(String name, String email, String cnpj, String businessName) {
        super(name, email);
        this.cnpj = cnpj;
        this.businessName = businessName;
    }
}
