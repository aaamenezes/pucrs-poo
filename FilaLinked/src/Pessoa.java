public class Pessoa {
    private String nome;
    Nascimento nascimento;

    constructor(String nome, Nascimento nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Nascimento getNascimento() {
        return this.nascimento.toString();
    }
}

class Nascimento {
    private int dia;
    private int mes;
    private int ano;

    constructor(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString() {
        return dia+"/"+mes+"/"+ano;
    }
}
