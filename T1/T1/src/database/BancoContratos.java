package database;

import java.util.ArrayList;

import dados.Contrato;

public class BancoContratos {
    private ArrayList<Contrato> contratos = new ArrayList<>();
    private int quantidade = 0;

    public ArrayList<Contrato> getContratos() {
        ArrayList<Contrato> contratosResultado = new ArrayList<Contrato>();

        for (Contrato contrato : this.contratos) {
            contratosResultado.add(contrato);
        }

        return contratosResultado;
    }

    public ArrayList<Contrato> getContratosPorCodigoJogo(int codigoJogo) {
        ArrayList<Contrato> contratosResultado = new ArrayList<Contrato>();

        for (Contrato contrato : this.contratos) {
            if (contrato.getJogo().getCodigo() == codigoJogo) {
                contratosResultado.add(contrato);
            }
        }

        return contratosResultado;
    }

    public void add(Contrato contrato) {
        this.contratos.add(contrato);
        this.quantidade++;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void remove(Contrato contrato) {
        this.contratos.remove(contrato);
        this.quantidade--;
    }

    public boolean temContrato(int id) {
        for (Contrato contrato : this.contratos) {
            if (contrato.getId() == id) {
                return true;
            }
        }

        return false;
    }
}
