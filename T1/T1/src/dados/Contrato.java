package dados;

public class Contrato {
    private int id;
    private int periodOfDays;
    private int clientId;
    private int gameId;

    public Contrato(int id, int periodOfDays, int clientId, int gameId) {
        this.id = id;
        this.periodOfDays = periodOfDays;
        this.clientId = clientId;
        this.gameId = gameId;
    }

    public int getId() {
        return this.id;
    }

    public int getPeriodOfDays() {
        return this.periodOfDays;
    }

    public int getClientId() {
        return this.clientId;
    }

    public int getGameId() {
        return this.gameId;
    }
}
