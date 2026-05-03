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

import database.BancoClientes;
import database.BancoContratos;
import database.BancoJogos;

import utils.CategoriaUtils;
// O diagrama de classes deve ser atualizado conforme as alterações realizadas e deve ser entregue em arquivo Astah ou PDF.
// https://moodle.pucrs.br/pluginfile.php/5810311/mod_resource/content/36/ProgOO-Trab1-2026-1.pdf

public class ACMESpiele {
    private final String nomeArquivoEntrada = "datain.txt";
    private final String nomeArquivoSaida = "dataout.txt";

    private final BancoClientes bancoClientes = new BancoClientes();
    private final BancoJogos bancoJogos = new BancoJogos();
    private final BancoContratos bancoContratos = new BancoContratos();

    private Scanner leitura = new Scanner(System.in);

    public ACMESpiele() {
        iniciarArquivoEntrada();
        iniciarArquivoSaida();
    }

    public void executar() {
        // 1. Cadastrar clientes individuais
        cadastrarClientesIndividuais();

        // 2. Cadastrar clientes corporativos
        cadastrarClientesCorporativos();

        // 3. Cadastrar jogos
        cadastrarJogos();

        // 4. Cadastrar contratos
        cadastrarContratos();

        // 5. Consultar um jogo pelo código
        int codigoConsulta = leitura.nextInt();
        leitura.nextLine();
        consultarJogoPeloCodigo(codigoConsulta);

        // 6. Consultar jogos de uma categoria
        String categoriaConsulta = leitura.nextLine();
        consultarJogosPorCategoria(categoriaConsulta);

        // 7. Mudar nome de um determinado cliente
        int numeroParaMudar = leitura.nextInt();
        leitura.nextLine();
        mudarNomeClientePorNumero(numeroParaMudar, leitura.nextLine());

        // 8. Remover contratos de um determinado jogo
        int codigoJogoParaRemover = leitura.nextInt();
        limparContratosJogoPorCodigo(codigoJogoParaRemover);

        // 9. Listar todos os contratos
        listarContratos();

        // 10. Mostra o cliente com maior valor contratado
        consultarClienteMaiorValorContrato();
    }

    /**
     * Métodos usados no executar()
     */

    private void cadastrarClientesIndividuais() {
        int proximoValor = leitura.nextInt();
        leitura.nextLine();

        while (proximoValor != -1) {
            int numero = proximoValor;
            boolean pularCliente = false;

            if (this.bancoClientes.getClientePorNumero(numero) != null) {
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
            }

            Individual clienteIndividual = new Individual(numero, nome, email, cpf);
            this.bancoClientes.add(clienteIndividual);
            System.out.println("1:" + clienteIndividual.descrever() + ";" + cpf);
        }
    }

    private void cadastrarClientesCorporativos() {
        int proximoValor = leitura.nextInt();
        leitura.nextLine();

        while (proximoValor != -1) {
            int numero = proximoValor;
            boolean pularCliente = false;

            if (this.bancoClientes.getClientePorNumero(numero) != null) {
                System.out.println("2:erro-numero repetido.");
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
            }

            Corporativo clienteCorporativo = new Corporativo(numero, nome, email, cnpj, nomeFantasia);
            this.bancoClientes.add(clienteCorporativo);
            System.out.println("2:" + clienteCorporativo.descrever() + ";" + cnpj + ";" + nomeFantasia);
        }
    }

    private void cadastrarJogos() {
        int proximoValor = leitura.nextInt();
        leitura.nextLine();

        while (proximoValor != -1) {
            int codigo = proximoValor;
            boolean pularCliente = false;

            if (this.bancoJogos.getJogoPeloCodigo(codigo) != null) {
                System.out.println("3:erro-codigo repetido.");
                pularCliente = true;
            }

            String nome = leitura.nextLine();
            int ano = leitura.nextInt();
            double valorMinuto = leitura.nextDouble();
            leitura.nextLine();

            Categoria categoriaEnum = CategoriaUtils.converterStringEnum(leitura.nextLine());

            proximoValor = leitura.nextInt();
            leitura.nextLine();

            if (pularCliente) {
                continue;
            }

            if (categoriaEnum == null) {
                System.out.println("3:erro-categoria inexistente.");
                continue;
            }

            Jogo jogo = new Jogo(codigo, nome, ano, valorMinuto, categoriaEnum);
            this.bancoJogos.add(jogo);
            System.out.println("3:" + jogo.descrever() + ";" + ano + ";" + valorMinuto + ";" + categoriaEnum);
        }
    }

    private void cadastrarContratos() {
        int proximoValor = leitura.nextInt();
        leitura.nextLine();

        while (proximoValor != -1) {
            int id = proximoValor;
            boolean pularContrato = false;

            if (this.bancoContratos.temContrato(id)) {
                System.out.println("4:erro-id repetido");
                pularContrato = true;
            }

            int periodo = leitura.nextInt();
            int numeroCliente = leitura.nextInt();
            Cliente cliente = this.bancoClientes.getClientePorNumero(numeroCliente);

            if (cliente == null) {
                System.out.println("4:erro-cliente inexistente.");
                pularContrato = true;
            }

            int codigoJogo = leitura.nextInt();
            Jogo jogo = this.bancoJogos.getJogoPeloCodigo(codigoJogo);

            if (jogo == null) {
                System.out.println("4:erro-jogo inexistente.");
                pularContrato = true;
            }

            proximoValor = leitura.nextInt();

            if (pularContrato) {
                continue;
            }

            Contrato contrato = new Contrato(id, periodo, cliente, jogo);
            this.bancoContratos.add(contrato);
            System.out.println("4:" + contrato.descrever());
        }
    }

    private void consultarJogoPeloCodigo(int codigo) {
        for (Jogo jogo : this.bancoJogos.getJogos()) {
            if (jogo.getCodigo() == codigo) {
                System.out.println("5:" + jogo.descrever() + ";" + jogo.getCategoria());
                return;
            }
        }

        System.out.println("5:erro-codigo inexistente.");
    }

    private void consultarJogosPorCategoria(String categoria) {
        Categoria categoriaEnum = CategoriaUtils.converterStringEnum(categoria);

        if (categoriaEnum == null) {
            System.out.println("6:erro-categoria inexistente.");
            return;
        }

        ArrayList<Jogo> jogosDaCategoria = this.bancoJogos.getJogosPorCategoria(categoriaEnum);

        if (jogosDaCategoria.size() == 0) {
            System.out.println("6:erro-nenhum jogo encontrado.");
            return;
        }

        for (Jogo jogo : jogosDaCategoria) {
            System.out.println("6:" + jogo.getCategoria() + ";" + jogo.getCodigo() + ";" + jogo.getNome());
        }
    }

    private void mudarNomeClientePorNumero(int numero, String novoNome) {
        for (Cliente cliente : this.bancoClientes.getClientes()) {
            if (cliente.getNumero() == numero) {

                cliente.setNome(novoNome);
                System.out.println("7:" + cliente.descrever() + ";" + cliente.getDocumento());
                return;
            }
        }

        System.out.println("7:erro-numero inexistente.");
    }

    private void limparContratosJogoPorCodigo(int codigo) {
        for (Jogo jogo : this.bancoJogos.getJogos()) {
            if (jogo.getCodigo() == codigo) {
                int codigoJogo = jogo.getCodigo();
                ArrayList<Contrato> contratosDoJogo = this.bancoContratos.getContratosPorCodigoJogo(codigoJogo);

                if (contratosDoJogo.size() == 0) {
                    System.out.println("8:nenhum contrato encontrado.");
                    return;
                }

                for (Contrato contratoParaRemover : contratosDoJogo) {
                    System.out.println("8:contrato removido: " + contratoParaRemover.getId());
                    this.bancoContratos.remove(contratoParaRemover);
                }
                return;
            }
        }

        System.out.println("8:erro-codigo inexistente.");
    }

    private void listarContratos() {
        if (this.bancoContratos.size() == 0) {
            System.out.println("9:erro-nenhum contrato cadastrado.");
            return;
        }

        for (Contrato contrato : this.bancoContratos.getContratos()) {
            System.out.println("9:" + contrato.descrever());
        }
    }

    private void consultarClienteMaiorValorContrato() {
        if (this.bancoContratos.size() == 0) {
            System.out.println("10:erro-nenhum contrato encontrado.");
            return;
        }

        Cliente clienteMaiorValorContrato = this.bancoClientes.getClientes().get(0);

        for (Cliente clienteAtual : this.bancoClientes.getClientes()) {
            if (!(clienteAtual instanceof Individual)) {
                continue;
            }

            boolean clienteAtualTemValorMaior = clienteAtual.getSomatorioValorContratos() > clienteMaiorValorContrato
                    .getSomatorioValorContratos();

            if (clienteAtualTemValorMaior) {
                clienteMaiorValorContrato = clienteAtual;
            }
        }

        if (clienteMaiorValorContrato.getSomatorioValorContratos() > 0) {
            System.out.println("10:" + clienteMaiorValorContrato.descrever() + ";"
                    + clienteMaiorValorContrato.getSomatorioValorContratos());
            return;
        }

        System.out.println("10:erro-nenhum cliente possui contrato ou contratos estão zerados.");
    }

    /**
     * Métodos usados no construtor
     */

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
}
