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
        this.somatorioValorContratos = 0;
    }

    public abstract String descrever();

    public int getNumero() {
        return this.numero;
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Contrato> getContratos() {
        ArrayList<Contrato> contratosResultado = new ArrayList<Contrato>();

        for (Contrato contrato : this.contratos) {
            contratosResultado.add(contrato);
        }

        return contratosResultado;
    }

    public int getQuantidadeContratos() {
        return this.contratos.size();
    }

    public void incrementarSomatorioValorContratos(double valor) {
        this.somatorioValorContratos += valor;
    }

    public void decrementarSomatorioValorContratos(double valor) {
        this.somatorioValorContratos -= valor;
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

    public void adicionarContrato(Contrato contrato) {
        this.contratos.add(contrato);
    }

    public void removerContrato(Contrato contrato) {
        this.contratos.remove(contrato);
    }

    public abstract String getDocumento();
}
