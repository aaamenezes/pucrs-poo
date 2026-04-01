public class Vendedor extends Funcionario {
    private double comissao;

    public Vendedor(String nome, double salarioBase, double descontos, double comissao ) {
        super(nome, salarioBase, descontos);
        this.comissao = comissao;
    }

    @Override
    public double calculaSalario() {
        return (super.calculaSalario()) + comissao * ( super.calculaSalario() );
    }

    @Override 
    public double calculaImposto() {
        if ( getSalario() <= 500 ) {
            return 0;
        } 

        if ( getSalario() <= 2000 ) {
            return getSalario() * 0.1;
        }

        return getSalario() * 0.2;
    }
    
}
