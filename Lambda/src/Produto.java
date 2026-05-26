public class Produto {

    // Enumeracao interna
    public enum Tipo {
        PERECIVEL, NAO_PERECIVEL;
    }

    private int codigo;
    private String nome;
    private double preco;
    private double imposto;
    private Tipo tipo = Tipo.PERECIVEL;

    public Produto(int codigo, String nome, double preco, double imposto, Tipo tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.imposto = imposto;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", imposto=" + imposto +
                ", tipo=" + tipo +
                '}';
    }
}
