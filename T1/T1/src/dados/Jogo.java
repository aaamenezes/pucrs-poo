package dados;

import java.util.ArrayList;

public class Jogo {
    private final int codigo;
    private String nome;
    private int ano;
    private double valorMinuto;
    private ArrayList<Contrato> contratos;
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

    public void adicionarContrato(Contrato contrato) {
        this.contratos.add(contrato);
    }

    public void removerContrato(Contrato contrato) {
        this.contratos.remove(contrato);
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
}
