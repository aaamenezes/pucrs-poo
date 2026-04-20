package dados;

public class Corporativo extends Cliente {
    private String cnpj;
    private String businessName;

    public Corporativo(int id, String name, String email, String cnpj, String businessName) {
        super(id, name, email);
        this.cnpj = cnpj;
        this.businessName = businessName;
    }
}
