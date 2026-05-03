package database;

import java.util.ArrayList;

import dados.Cliente;

public class BancoClientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> clientesResultado = new ArrayList<Cliente>();

        for (Cliente cliente : this.clientes) {
            clientesResultado.add(cliente);
        }

        return clientesResultado;
    }

    public void adicionar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Cliente getClientePorNumero(int numero) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getNumero() == numero) {
                return cliente;
            }
        }

        return null;
    }
}
