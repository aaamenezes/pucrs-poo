package aplicacao;

import java.util.ArrayList;
import java.util.List;

import dados.Baldio;
import dados.Terreno;
import dados.Vendavel;

public class App {
    private List<Terreno> terrenos;
    private List<Vendavel> vendaveis;

    public App() {
        terrenos = new ArrayList<Terreno>();
        terrenos.add(new Terreno(111, 11));
        terrenos.add(new Terreno(222, 22));
        terrenos.add(new Baldio(333, 33, 5));

        vendaveis = ArrayList<Vendavel>();

        vendaveis.add(new Terreno(444, 44));
        vendaveis.add(new Baldio(555, 55));
    }

    public void executar() {
        for (Terreno terreno : this.terrenos) {
            System.out.println(terreno);
            System.out.println(terreno.calculaVenda());
            System.out.println("--------------");
        }
    }
}
