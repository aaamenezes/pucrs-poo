package dados;

public class Contrato {
    private int id;
    private int periodOfDays;
    private Cliente client;
    private Jogo game;

    public Contrato(int id, int periodOfDays, Cliente client, Jogo game) {
        this.id = id;
        this.periodOfDays = periodOfDays;
        this.client = client;
        this.game = game;
    }

    public int getId() {
        return this.id;
    }

    public int getPeriodOfDays() {
        return this.periodOfDays;
    }

    public Cliente getClient() {
        return this.client;
    }

    public Jogo getGame() {
        return this.game;
    }
}
