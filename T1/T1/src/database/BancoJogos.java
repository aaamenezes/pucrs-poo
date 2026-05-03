package database;

import java.util.ArrayList;

import dados.Categoria;
import dados.Jogo;

public class BancoJogos {
    private ArrayList<Jogo> jogos = new ArrayList<>();
    private int quantidade = 0;

    public ArrayList<Jogo> getJogos() {
        ArrayList<Jogo> jogosResultado = new ArrayList<Jogo>();

        for (Jogo jogo : this.jogos) {
            jogosResultado.add(jogo);
        }

        return jogosResultado;
    }

    public void add(Jogo jogo) {
        this.jogos.add(jogo);
        this.quantidade++;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public Jogo getJogoPeloCodigo(int codigo) {
        for (Jogo jogo : this.jogos) {
            if (jogo.getCodigo() == codigo) {
                return jogo;
            }
        }

        return null;
    }

    public ArrayList<Jogo> getJogosPorCategoria(Categoria categoria) {
        ArrayList<Jogo> jogosFiltradosPorCategoria = new ArrayList<>();

        for (Jogo jogo : this.jogos) {
            if (jogo.getCategoria() == categoria) {
                jogosFiltradosPorCategoria.add(jogo);
            }
        }

        return jogosFiltradosPorCategoria;
    }
}
