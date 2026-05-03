package database;

import java.util.ArrayList;

import dados.Contrato;

public class BancoContratos {
    private ArrayList<Contrato> contratos = new ArrayList<>();

    public ArrayList<Contrato> getContratos() {
        ArrayList<Contrato> contratosResultado = new ArrayList<Contrato>();

        for (Contrato contrato : this.contratos) {
            contratosResultado.add(contrato);
        }

        return contratosResultado;
    }

    public void add(Contrato contrato) {
        this.contratos.add(contrato);
    }

    public void remove(Contrato contrato) {
        this.contratos.remove(contrato);
    }

    public int size() {
        return this.contratos.size();
    }
}
