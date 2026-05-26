import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Aplicacao {

    // Colecao de produtos
    private ArrayList<Produto> estoque;

    // Inicializacao da colecao
    public Aplicacao() {
        estoque = new ArrayList<>();
        estoque.add(new Produto(111,"Abacate",11.11,1.11, Produto.Tipo.PERECIVEL));
        estoque.add(new Produto(222,"Computador",22222.22,22.22, Produto.Tipo.NAO_PERECIVEL));
        estoque.add(new Produto(333,"Carne",33.33,3.33, Produto.Tipo.PERECIVEL));
        estoque.add(new Produto(444,"TV",4444.44,44.44, Produto.Tipo.NAO_PERECIVEL));
        estoque.add(new Produto(555,"Web Cam",555.55,5.55, Produto.Tipo.NAO_PERECIVEL));
        estoque.add(new Produto(666,"Tomate",66.66,66.66, Produto.Tipo.PERECIVEL));
        estoque.add(new Produto(777,"Tablet",777.77,77.77, Produto.Tipo.NAO_PERECIVEL));
    }

    public void executa() {
        // Desafio 1: Mostrar todos os dados dos produtos do estoque
        System.out.println("\n====================");
        System.out.println("1: Mostrar todos os dados dos produtos do estoque");
        // this.estoque.stream().forEach(p -> System.out.println(p));

        // Desafio 2: Mostrar todos codigos dos produtos do estoque
        System.out.println("\n====================");
        System.out.println("2: Mostrar todos codigos dos produtos do estoque");
        // this.estoque.stream().mapToInt(Produto::getCodigo).forEach(System.out::println);

        // Desafio 3: Mostrar todos nomes dos produtos do estoque
        System.out.println("\n====================");
        System.out.println("3: Mostrar todos nomes dos produtos do estoque");
        // this.estoque.stream().map(p -> p.getNome()).forEach(System.out::println);

        // Desafio 4: Mostrar todos precos dos produtos do estoque
        System.out.println("\n====================");
        System.out.println("4: Mostrar todos precos dos produtos do estoque");
        // this.estoque.stream().map(p -> p.getPreco()).forEach(System.out::println);

        // Desafio 5: Mostrar o somatorio de preco de todos os produtos do estoque
        System.out.println("\n====================");
        System.out.println("5: Mostrar o somatorio de preco de todos os produtos do estoque");
        // System.out.println(this.estoque.stream().mapToDouble(Produto::getPreco).sum());

        // Desafio 6: Mostrar o somatorio de impostos de todos os produtos do estoque
        System.out.println("\n====================");
        System.out.println("6: Mostrar o somatorio de impostos de todos os produtos do estoque");
        // System.out.println(this.estoque.stream().mapToDouble(Produto::getImposto).sum());

        // Desafio 7: Mostrar a quantidade de produtos do estoque
        System.out.println("\n====================");
        System.out.println("7: Mostrar a quantidade de produtos do estoque");
        // System.out.println(this.estoque.size());

        // Desafio 8: Mostrar a quantidade de produtos do estoque com imposto acima de 10.00
        System.out.println("\n====================");
        System.out.println("8: Mostrar a quantidade de produtos do estoque com imposto acima de 10.00");
        // System.out.println(this.estoque.stream().filter(p -> p.getImposto() > 10).collect(Collectors.toList()).size());

        // Desafio 9: Mostrar a quantidade de produtos do estoque do tipo PERECIVEL
        System.out.println("\n====================");
        System.out.println("9: Mostrar a quantidade de produtos do estoque do tipo PERECIVEL");
        // System.out.println(
        //     this
        //         .estoque
        //         .stream()
        //         .filter(p -> p.getTipo() == Produto.Tipo.PERECIVEL)
        //         .collect(Collectors.toList())
        //         .size()

        // );

        // Desafio 10: Mostrar os produtos do estoque com preco acima de 1000.00
        System.out.println("\n====================");
        System.out.println("10: Mostrar os dados os produtos do estoque com preco acima de 1000.00");
        // this.estoque.stream().filter(p -> p.getPreco() > 1000).forEach(System.out::println);

        // Desafio 11: Mostrar os nomes dos produtos do estoque com preco abaixo de 100.00
        System.out.println("\n====================");
        System.out.println("11: Mostrar os nomes dos produtos do estoque com preco abaixo de 100.00");
        // this.estoque.stream().filter(p -> p.getPreco() < 100).forEach(p -> System.out.println(p.getNome()));

        // Desafio 12: Mostrar a media de precos dos produtos do estoque com preco entre 100.00 e 1000.00
        System.out.println("\n====================");
        System.out.println("12: Mostrar a media de precos dos produtos do estoque com preco entre 100.00 e 1000.00");
        System.out.println("FALTOU ALGUMA COISA NESSE EXERCICIO AQUI. EXECUTAR PARA VER");
        System.out.println(
            this
                .estoque
                .stream()
                .filter(p -> p.getPreco() >= 100 && p.getPreco() <= 1000)
                .mapToDouble(Produto::getPreco)
                .average()
        );

        // Desafio 13: Mostrar os codigos e nomes dos produtos com imposto acima de 40.00
        System.out.println("\n====================");
        System.out.println("13: Mostrar os codigos, nomes e impostos dos produtos com imposto acima de 40.00");


        // Desafio 14: criar uma lista com os produtos de preco acima de 1000.00
        // Depois mostra os produtos desta nova lista
        System.out.println("\n====================");
        System.out.println("14: Criar uma lista com os codigos e nomes dos produtos de preco acima de 1000.00");
        System.out.println("Depois mostra dados desta nova lista");


        // Desafio 15: Criar uma lista com os nomes e impostos dos produtos de imposto menor que 10.00
        // Depois mostra os produtos desta nova lista
        System.out.println("\n====================");
        System.out.println("15: Criar uma lista com os codigos e nomes dos produtos de imposto menor que 10.00");
        System.out.println("Depois mostra dados desta nova lista");


        // Desafio 16: Criar um dicionario com listas (para PERECIVEL e NAO_PERECIVEL)
        // Depois mostra os produtos do dicionario por tipo
        System.out.println("\n====================");
        System.out.println("16: Criar um dicionario com listas (para PERECIVEL e NAO_PERECIVEL)");
        System.out.println("Depois mostra os produtos do dicionario por tipo");


    }

}
