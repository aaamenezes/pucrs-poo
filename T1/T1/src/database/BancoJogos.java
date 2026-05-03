package database;

import java.util.ArrayList;

import dados.Jogo;

public class BancoJogos {
    private ArrayList<Jogo> jogos = new ArrayList<>();

    public ArrayList<Jogo> getJogos() {
        ArrayList<Jogo> jogosResultado = new ArrayList<Jogo>();

        for (Jogo jogo : this.jogos) {
            jogosResultado.add(jogo);
        }

        return jogosResultado;
    }

    public void add(Jogo jogo) {
        this.jogos.add(jogo);
    }
}
