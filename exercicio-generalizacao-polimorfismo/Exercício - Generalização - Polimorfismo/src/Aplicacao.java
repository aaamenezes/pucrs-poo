import java.util.Scanner;

public class Aplicacao {
    private Equipe equipe;
    private Scanner entrada;

    public Aplicacao() {
        equipe = new Equipe();
        entrada = new Scanner(System.in);
    }

    public void inicializa() {
        Vendedor v;
        Gerente g;
        g = new Gerente("Maria",1111.11,11.11,"Mobile",1.1);
        equipe.addFuncionario(g);
        g = new Gerente("Pedro",222.22,22.22,"Web",2.2);
        equipe.addFuncionario(g);
        v = new Vendedor( "Bruno", 3333.33, 33.33, 3.3 );
        equipe.addFuncionario(v);
    }

    public void executa() {
        int opcao = 0;
        do {
            System.out.println("===================");
            System.out.println("Opcoes:");
            System.out.println("[0] Sair");
            System.out.println("[1] Consulta por nome");
            System.out.println("[2] Cadastrar vendedor:");
            System.out.print("Digite a opcao desejada: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 2:
                    cadastrarVendedor();
                    break;
                case 1:
                    consultaPorNome();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while(opcao != 0);
    }

    private void consultaPorNome() {
        System.out.println("===================");
        System.out.print("Digite o nome do funcionario: ");
        String nome = entrada.nextLine();
        Funcionario f = equipe.pesquisaNome(nome);
        if(f == null)
            System.out.println("Erro. Nao ha funcionario com este nome");
        else {
            System.out.println(f.geraDescricao());
        }
    }

    private void cadastrarVendedor() {
        System.out.println("Informe o nome do vendedor: ");
        String nome = entrada.nextLine();
        
        System.out.println("Informe o salário base: ");
        double salarioBase = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Informe os descontos: ");
        double descontos = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Informe a comissão: ");
        double comissao = entrada.nextDouble();
        entrada.nextLine();

        Vendedor vendedor = new Vendedor(nome, salarioBase, descontos, comissao);

        this.equipe.addFuncionario(vendedor);
    }

}
