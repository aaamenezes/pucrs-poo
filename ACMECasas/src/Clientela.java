import java.util.ArrayList;

public class Clientela {
    private ArrayList<Cliente> clientes;

    public Clientela() {
        this.clientes = new ArrayList<Cliente>();
    }

    public boolean cadastrarCliente(Cliente cliente) {
        return this.clientes.add(cliente);
    }

    public Cliente consultarClientePorNome(String nome) {
        for (Cliente cliente : this.clientes) {
            if(cliente.getNome().equals(nome))
                return cliente;
        }

        return null;
    }
}
