package dados;

public class Contrato {
    private int id;
    private int periodo;
    private Cliente cliente;
    private Jogo jogo;

    public Contrato(int id, int periodo, Cliente cliente, Jogo jogo) {
        this.id = id;
        this.periodo = periodo;
        this.cliente = cliente;
        this.jogo = jogo;
    }

    public int getId() {
        return this.id;
    }

    public int getPeriodo() {
        return this.periodo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Jogo getJogo() {
        return this.jogo;
    }

    public String descrever() {
        return this.id + ";" + this.periodo + ";" + this.cliente.getNumero() + ";" + this.jogo.getCodigo();
    }
}
