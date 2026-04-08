package dados;

public class Terreno implements Vendavel {
    private double tamanho;
    private double preco;

    public Terreno(double tamanho, double preco) {
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public String toString() {
        return "Tamanho: " + this.tamanho + "\n" + "Preço: " + this.preco;
    }

    public double getPreco() {
        return this.preco;
    }

    @Override
    public double calculaVenda() {
        return this.preco * 0.5;
    }
}
