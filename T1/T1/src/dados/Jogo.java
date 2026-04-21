package dados;

import java.util.ArrayList;

public class Jogo {
    private int id;
    private String name;
    private int year;
    private double valuePerMinute;
    private String category;
    private ArrayList<Contrato> contracts = new ArrayList<>();

    public Jogo(int id, String name, int year, double valuePerMinute, Categoria category) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.valuePerMinute = valuePerMinute;
        this.category = category.getDescription();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public ArrayList<Contrato> getContracts() {
        return this.contracts;
    }

    public void clearContracts() {
        this.contracts.clear();
    }
}
