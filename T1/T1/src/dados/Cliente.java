package dados;

import java.util.ArrayList;

public abstract class Cliente {
    private final int numero;
    private String nome;
    private String email;
    private ArrayList<Contrato> contratos;
    private double somatorioValorContratos;

    public Cliente(int numero, String nome, String email) {
        this.numero = numero;
        this.nome = nome;
        this.email = email;
        this.contratos = new ArrayList<Contrato>();
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

    public ArrayList<Contrato> getContratos() {
        return this.contratos;
    }

    public void adicionarContrato(Contrato contrato) {
        this.contratos.add(contrato);

        double valorContratoAtual = contrato.getJogo().getValorMinuto();
        this.somatorioValorContratos += valorContratoAtual;
    }

    public abstract String getDocumento();
}
