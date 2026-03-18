import java.util.ArrayList;

public class Cliente {
    private String nome;
    private ArrayList<Casa> casas;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void comprarCasa(Casa casa) {
        casas.add(casa);
    }

    public ArrayList<Casa> consultarCasasCompradas() {
        ArrayList<Casa> auxCasas = new ArrayList<>();

        for (Casa aux : this.casas) {
            auxCasas.add(aux);
        }

        return auxCasas;
    }
}
