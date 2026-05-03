package dados;

import java.util.ArrayList;

public class Jogo {
    private int codigo;
    private String nome;
    private int ano;
    private double valorMinuto;
    private Categoria categoria;
    private ArrayList<Contrato> contratos;

    public Jogo(int codigo, String nome, int ano, double valorMinuto, Categoria categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.ano = ano;
        this.valorMinuto = valorMinuto;
        this.categoria = categoria;
        this.contratos = new ArrayList<>();
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

    public ArrayList<Contrato> getContratos() {
        return this.contratos;
    }

    public void zerarContratos() {
        this.contratos.clear();
    }

    public void adicionarContrato(Contrato contrato) {
        this.contratos.add(contrato);
    }

    public double getValorMinuto() {
        return this.valorMinuto;
    }
}
