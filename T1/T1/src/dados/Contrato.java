package dados;

public class Contrato {
    private int id;
    private int periodOfDays;

    public Contrato(int id, int periodOfDays) {
        this.id = id;
        this.periodOfDays = periodOfDays;
    }

    public int getId() {
        return this.id;
    }
}
