package dados;

public abstract class Cliente {
    private final int numero;
    private String nome;
    private String email;
    private double somatorioValorContratos;

    public Cliente(int numero, String nome, String email) {
        this.numero = numero;
        this.nome = nome;
        this.email = email;
        this.somatorioValorContratos = 0;
    }

    public abstract String descrever();

    public int getNumero() {
        return this.numero;
    }

    public String getNome() {
        return this.nome;
    }

    public double getSomatorioValorContratos() {
        return this.somatorioValorContratos;
    }

    public void setNome(String nome) {
        if (nome.equals("")) {
            return;
        }

        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public abstract String getDocumento();
}
