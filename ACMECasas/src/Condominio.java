import java.util.ArrayList;

public class Condominio {
  private ArrayList<Casa> casas;

  public Condominio() {
    this.casas = new ArrayList<Casa>();
  }

  // CREATE
  public void cadastrarCasa(Casa casa) {
    casas.add(casa);
  }

  // READ
  public Casa consultarCasa(String endereco) {
    for (int i = 0; i < casas.size(); i++) {
      Casa casaAtual = casas.get(i);

      if (casaAtual.getEndereco().equals(endereco)) {
        return casaAtual;
      }
    }

    return null;
  }

  
}