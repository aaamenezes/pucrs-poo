package dados;

public class Jogo {
    private final int codigo;
    private String nome;
    private int ano;
    private double valorMinuto;
    private Categoria categoria;

    public Jogo(int codigo, String nome, int ano, double valorMinuto, Categoria categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.ano = ano;
        this.valorMinuto = valorMinuto;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public double getValorMinuto() {
        return this.valorMinuto;
    }

    public String descrever() {
        return this.codigo + ";" + this.nome;
    }

    public int getAno() {
        return this.ano;
    }
}
