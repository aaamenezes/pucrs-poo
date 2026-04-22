package dados;

import java.util.ArrayList;

public class Jogo {
    private int id;
    private String name;
    private int year;
    private double valuePerMinute;
    private String category;
    private ArrayList<Integer> contractIds;

    public Jogo(int id, String name, int year, double valuePerMinute, Categoria category) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.valuePerMinute = valuePerMinute;
        this.category = category.getDescription();
        this.contractIds = new ArrayList<>();
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

    public ArrayList<Integer> getContractIds() {
        return this.contractIds;
    }

    public void clearContracts() {
        this.contractIds.clear();
    }

    public void addContractId(int contractId) {
        this.contractIds.add(contractId);
    }
}
