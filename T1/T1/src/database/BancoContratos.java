package database;

import java.util.ArrayList;

import dados.Cliente;
import dados.Contrato;
import dados.Jogo;

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

    public BancoContratos getContratosPorCodigoJogo(int codigoJogo) {
        BancoContratos contratosResultado = new BancoContratos();

        for (Contrato contrato : this.contratos) {
            if (contrato.getJogo().getCodigo() == codigoJogo) {
                contratosResultado.adicionar(contrato);
            }
        }

        return contratosResultado;
    }

    public void adicionar(Contrato contrato) {
        this.contratos.add(contrato);

        Cliente cliente = contrato.getCliente();
        cliente.adicionarContrato(contrato);

        Jogo jogo = contrato.getJogo();
        jogo.adicionarContrato(contrato);

        double valorMinuto = jogo.getValorMinuto();
        cliente.incrementarSomatorioValorContratos(valorMinuto);

        this.quantidade++;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void remover(Contrato contrato) {
        contrato.getCliente().removerContrato(contrato);
        contrato.getJogo().removerContrato(contrato);
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
