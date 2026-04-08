package dados;

public class Baldio extends Terreno {
    private double areaInutil;

    public Baldio(double tamanho, double preco, double areaInutil) {
        super(tamanho, preco);
        this.areaInutil = areaInutil;
    }

    public String toString() {
        return super.toString() + "\n" + "Área inútil " + this.areaInutil;
    }

    @Override
    public double calculaVenda() {
        return this.getPreco() * 0.4;
    }
}
