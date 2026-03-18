import java.util.ArrayList;

public class Condominio {
    private ArrayList<Casa> casas;

    public Condominio() {
        casas = new ArrayList<Casa>();
    }

    // Operacao "C" - criar/cadastrar
    public boolean cadastrarCasa(Casa c) {
        return casas.add(c);
    }

    // Operacao "R" - consultar
    public Casa consultarCasaEndereco(String endereco) {
        // for(int i=0; i<casas.size();i++) {
        //     Casa aux = casas.get(i);
        //     if(aux.getEndereco().equals(endereco))
        //         return aux;
        // }
        
        for (Casa casa : casas) {
            if(casa.getEndereco().equals(endereco))
                return casa;
        }

        return null;
    }

    public boolean casaExiste(String endereco) {
        for (Casa casa : this.casas) {
            if(casa.getEndereco().equals(endereco))
                return true;
        }

        return false;
    }

    /**
     * R - Retrieve
     * Consulta todas as casas cadastradas
     * @return lista auxiliar com casas cadastradas
     */
    public ArrayList<Casa> consultarTodasCasas() {
        // ArrayList auxiliar para o retorno
        ArrayList<Casa> aux = new ArrayList<>();
        // for(int i=0; i< casas.size(); i++) {
        //     Casa casa = casas.get(i);
        //     aux.add(casa);
        // }

        for(Casa casa : casas) {
            aux.add(casa);
        }

        return aux;
    }

    public ArrayList<Casa> consultarCasasPorTamanho(int tamanho) {
        ArrayList<Casa> casasAuxilar = new ArrayList<Casa>();

        // for (int i = 0; i < casas.size(); i++) {
        //     Casa casa = casas.get(i);
        //     if (casa.getTamanho() == tamanho) {
        //     casasAuxilar.add(casa);
        //     }
        // }

        for (Casa casa : casas) {
            if (casa.getTamanho() == tamanho) {
                casasAuxilar.add(casa);
            }
        }


        return casasAuxilar;
    }
}
