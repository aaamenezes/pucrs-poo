import java.util.ArrayList;

public class Conta {
  // Array
  String[] names;

  // ArrayList
  ArrayList<String> transacoes = new ArrayList<String>();

  public static void main(String[] args) {
    // Array
    names = new String[100];

    // ArrayList
    names = new ArrayList<String>(100); // limite 100
    names = new ArrayList<String>(); // limite 10

    // ...

    // Array
    names.length; // capacidade inicial

    // ArrayList
    names.size(); // quantos objetos tem de fato na lista

    // ...

    // Array
    names[0] = "Texto";

    // ArrayList
    names.set(0, "Texto");

    // ...

    // Array
    names[3];

    // ArrayList
    names.get(3);

    // ...

    // ArrayList só adiciona
    names.add("Texto 2");

    // ArrayList adiciona numa posição específica
    // Ele empurra pra ti
    names.add(9, "Texto 2");

    // Limpar
    names.clear();
    indexOf
    lastIndexOf
    contains
    isEmpty

    /**
     * Array é uma lista de tamanho fixo
     * ArrayList é uma lista de tamanho flexível
     */
  }
}