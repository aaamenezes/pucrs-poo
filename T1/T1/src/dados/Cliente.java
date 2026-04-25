package dados;

import java.util.ArrayList;

public abstract class Cliente {
    private int id;
    private String name;
    private String email;
    private ArrayList<Contrato> contracts;
    private double totalContratValue;

    public Cliente(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contracts = new ArrayList<Contrato>();
        this.totalContratValue = 0;
    }

    public String describe() {
        return this.id + ";" + this.name + ";" + this.email;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getTotalContractValue() {
        return this.totalContratValue;
    }

    public void setName(String name) {
        if (name.equals("")) {
            return;
        }

        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public ArrayList<Contrato> getContracts() {
        return this.contracts;
    }

    public void addContract(Contrato contract) {
        this.contracts.add(contract);

        double currentContractValue = contract.getPeriodOfDays() * contract.getGame().getValuePerMinute();
        this.totalContratValue += currentContractValue;
    }
}
