public class VeiculoEletrico extends Veiculo {
    private double cargaBateria;

    public VeiculoEletrico(String placa, double valor, double cargaBateria) {
        super(placa, valor);
        this.cargaBateria = cargaBateria;
    }

    @Override
    public double calculaIPVA() {
        return 0;
    }

    @Override
    public String geraDescricao() {
        return super.geraDescricao() + "Carga da bateria: " + this.cargaBateria;
    }
}
