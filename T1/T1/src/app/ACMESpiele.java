package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import dados.Categoria;
import dados.Cliente;
import dados.Contrato;
import dados.Corporativo;
import dados.Individual;
import dados.Jogo;
// O diagrama de classes deve ser atualizado conforme as alterações realizadas e deve ser entregue em arquivo Astah ou PDF.
// https://moodle.pucrs.br/pluginfile.php/5810311/mod_resource/content/36/ProgOO-Trab1-2026-1.pdf

public class ACMESpiele {
    private final String nomeArquivoEntrada = "datain.txt";
    private final String nomeArquivoSaida = "dataout.txt";

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Jogo> jogos = new ArrayList<>();
    private ArrayList<Contrato> contratos = new ArrayList<>();

    private Scanner leitura = new Scanner(System.in);

    public ACMESpiele() {
        iniciarArquivoEntrada();
        iniciarArquivoSaida();
    }

    public void executar() {
        cadastrarClientesIndividuais();
        cadastrarClientesCorporativos();
        cadastrarJogos();
        cadastrarContratos();

        int codigoConsulta = leitura.nextInt();
        leitura.nextLine();
        consultarJogoPeloCodigo(codigoConsulta); // 444

        String categoriaConsulta = leitura.nextLine();
        consultarJogosPorCategoria(categoriaConsulta); // AVENTURA

        int numeroParaMudar = leitura.nextInt();
        leitura.nextLine();
        mudarNomeClientePorNumero(numeroParaMudar, "Fulano de Tal");

        limparContratosJogoPorCodigo(333);
        listarContratos();
        consultarClienteMaiorValorContrato();
    }

    private void cadastrarClientesIndividuais() {
        int proximoValor = leitura.nextInt();
        leitura.nextLine();

        while (proximoValor != -1) {
            int numero = proximoValor;
            boolean pularCliente = false;

            if (getClientePorNumero(numero) != null) {
                System.out.println("1:erro-numero repetido");
                pularCliente = true;
            }

            String nome = leitura.nextLine();
            String email = leitura.nextLine();
            String cpf = leitura.nextLine();

            proximoValor = leitura.nextInt();
            leitura.nextLine();

            if (pularCliente) {
                continue;
            } else {
                Individual clienteIndividual = new Individual(numero, nome, email, cpf);
                clientes.add(clienteIndividual);
                System.out.println("1:" + numero + ";" + nome + ";" + email + ";" + cpf);
            }
        }
    }

    private void cadastrarClientesCorporativos() {
        int proximoValor = leitura.nextInt();
        leitura.nextLine();

        while (proximoValor != -1) {
            int numero = proximoValor;
            boolean pularCliente = false;

            if (getClientePorNumero(numero) != null) {
                System.out.println("2:erro-numero repetido");
                pularCliente = true;
            }

            String nome = leitura.nextLine();
            String email = leitura.nextLine();
            String cnpj = leitura.nextLine();
            String nomeFantasia = leitura.nextLine();

            proximoValor = leitura.nextInt();
            leitura.nextLine();

            if (pularCliente) {
                continue;
            } else {
                Corporativo clienteCorporativo = new Corporativo(numero, nome, email, cnpj, nomeFantasia);
                clientes.add(clienteCorporativo);
                System.out.println("2:" + numero + ";" + nome + ";" + email + ";" + cnpj + ";" + nomeFantasia);
            }
        }
    }

    private void cadastrarJogos() {
        int proximoValor = leitura.nextInt();
        leitura.nextLine();

        while (proximoValor != -1) {
            int codigo = proximoValor;

            if (getJogoPeloCodigo(codigo) != null) {
                System.out.println("3:erro-codigo repetido");
            }

            String nome = leitura.nextLine();
            int ano = leitura.nextInt();
            double valorMinuto = leitura.nextDouble();
            leitura.nextLine();

            Categoria categoriaEnum = Categoria.valueOf(leitura.nextLine());
            String categoriaDescricao = categoriaEnum.getDescricao();

            proximoValor = leitura.nextInt();
            leitura.nextLine();

            if (categoriaDescricao == null) {
                System.out.println("3:erro-categoria inexistente");
                continue;
            }

            Jogo jogo = new Jogo(codigo, nome, ano, valorMinuto, categoriaEnum);
            jogos.add(jogo);
            System.out.println(
                    "3:" + codigo + ";" + nome + ";" + ano + ";" + valorMinuto + ";" + categoriaDescricao);
        }
    }

    private void cadastrarContratos() {
        int proximoValor = leitura.nextInt();
        leitura.nextLine();

        while (proximoValor != -1) {
            int id = proximoValor;
            boolean pularContrato = false;

            if (temContrato(id)) {
                System.out.println("4:erro-id repetido");
                pularContrato = true;
            }

            int periodo = leitura.nextInt();
            int numeroCliente = leitura.nextInt();
            Cliente cliente = getClientePorNumero(numeroCliente);

            if (cliente == null) {
                System.out.println("4:erro-cliente inexistente");
                pularContrato = true;
            }

            int codigoJogo = leitura.nextInt();
            Jogo jogo = getJogoPeloCodigo(codigoJogo);

            if (jogo == null) {
                System.out.println("4:erro-jogo inexistente");
                pularContrato = true;
            }

            proximoValor = leitura.nextInt();

            if (pularContrato) {
                continue;
            } else {
                Contrato contrato = new Contrato(id, periodo, cliente, jogo);
                jogo.adicionarContrato(contrato);
                cliente.adicionarContrato(contrato);
                this.contratos.add(contrato);
                System.out.println("4:" + id + ";" + periodo + ";" + numeroCliente + ";" + codigoJogo);
            }

        }
    }

    private void consultarJogoPeloCodigo(int codigo) {
        for (Jogo jogo : this.jogos) {
            if (jogo.getCodigo() == codigo) {
                System.out.println("5:" + codigo + ";" + jogo.getNome() + ";" + jogo.getCategoria());
                return;
            }
        }

        System.out.println("5:erro-codigo inexistente");
    }

    private void consultarJogosPorCategoria(String categoria) {
        String categoriaDescricao = Categoria.valueOf(categoria).getDescricao();

        if (categoriaDescricao == null) {
            System.out.println("6:erro-categoria inexistente.");
            return;
        }

        ArrayList<Jogo> jogos = getJogosPorCategoria(categoriaDescricao);

        if (jogos.size() == 0) {
            System.out.println("6:erro-nenhum jogo encontrado.");
            return;
        }

        for (Jogo jogo : jogos) {
            System.out.println("6:" + jogo.getCategoria() + ";" + jogo.getCodigo() + ";" + jogo.getNome());
        }
    }

    private void mudarNomeClientePorNumero(int numero, String novoNome) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getNumero() == numero) {
                cliente.setNome(novoNome);
                System.out.println("7:" + numero + ";" + novoNome + ";" + cliente.getEmail());
                return;
            }
        }

        System.out.println("7:erro-numero inexistente.");
    }

    private void limparContratosJogoPorCodigo(int codigo) {
        for (Jogo jogo : this.jogos) {
            if (jogo.getCodigo() == codigo) {
                if (jogo.getContratos().size() == 0) {
                    System.out.println("8:nenhum contrato encontrado.");
                    return;
                }

                for (Contrato contrato : jogo.getContratos()) {
                    System.out.println("8:contrato removido: " + contrato.getId());
                }

                jogo.zerarContratos();
                return;
            }
        }

        System.out.println("8:erro-codigo inexistente.");
    }

    private void listarContratos() {
        if (this.contratos.size() == 0) {
            System.out.println("9:erro-nenhum contrato cadastrado");
            return;
        }

        for (Contrato contrato : this.contratos) {
            System.out.println(
                    "9:" + contrato.getId() + ";" + contrato.getPeriodo() + ";" + contrato.getCliente().getNumero()
                            + ";" + contrato.getJogo().getCodigo());
        }
    }

    private void consultarClienteMaiorValorContrato() {
        if (this.contratos.size() == 0) {
            System.out.println("10:erro-nenhum contrato encontrado.");
            return;
        }

        Cliente clienteMaiorValorContrato = this.clientes.get(0);

        for (Cliente clienteAtual : this.clientes) {
            boolean clienteAtualTemValorMaior = clienteAtual.getSomatorioValorContratos() > clienteMaiorValorContrato
                    .getSomatorioValorContratos();

            if (clienteAtualTemValorMaior) {
                clienteMaiorValorContrato = clienteAtual;
            }
        }

        if (clienteMaiorValorContrato.getSomatorioValorContratos() > 0) {
            System.out
                    .println("10:" + clienteMaiorValorContrato.getNumero() + ";" + clienteMaiorValorContrato.getNome()
                            + ";" + clienteMaiorValorContrato.getEmail() + ";"
                            + clienteMaiorValorContrato.getSomatorioValorContratos());
            return;
        }

        System.out.println("10:erro-nenhum cliente possui contrato ou contratos estão zerados.");
    }

    private void iniciarArquivoEntrada() {
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            leitura = new Scanner(entrada);

            Locale.setDefault(Locale.ENGLISH);
            leitura.useLocale(Locale.ENGLISH);
        } catch (Exception erro) {
            System.out.println("Erro ao criar leitor de entrada via arquivo: " + erro);
        }
    }

    private void iniciarArquivoSaida() {
        try {
            PrintStream saida = new PrintStream(new File(this.nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(saida);
        } catch (Exception erro) {
            System.out.println("Erro ao iniciarArquivoSaida: " + erro);
        }

        Locale.setDefault(Locale.ENGLISH);
    }

    private Cliente getClientePorNumero(int numero) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getNumero() == numero) {
                return cliente;
            }
        }

        return null;
    }

    private Jogo getJogoPeloCodigo(int codigo) {
        for (Jogo jogo : this.jogos) {
            if (jogo.getCodigo() == codigo) {
                return jogo;
            }
        }

        return null;
    }

    private boolean temContrato(int id) {
        for (Contrato contrato : this.contratos) {
            if (contrato.getId() == id) {
                return true;
            }
        }

        return false;
    }

    private ArrayList<Jogo> getJogosPorCategoria(String categoria) {
        ArrayList<Jogo> jogosFiltradosPorCategoria = new ArrayList<>();

        for (Jogo jogo : this.jogos) {
            if (jogo.getCategoria().equals(categoria)) {
                jogosFiltradosPorCategoria.add(jogo);
            }
        }

        return jogosFiltradosPorCategoria;
    }
}
