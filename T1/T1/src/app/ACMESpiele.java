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

public class ACMESpiele {
    private final String dataInFileName = "datain.txt";
    private final String dataOutFileName = "dataout.txt";

    private ArrayList<Cliente> clients = new ArrayList<>();
    private ArrayList<Jogo> games = new ArrayList<>();
    private ArrayList<Contrato> contracts = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public ACMESpiele() {
        createFileIn();
        createFileOut();
    }

    public void exec() {
        registerIndividualClients();
        registerCorporateClientes();
        registerGames();
        registerContracts();
        readGameById();
        readGamesByCategory();
        updateClientNameById();
        clearGameContractsById();
        listContracts();
        readHighestContractValueClient();
    }

    private void registerIndividualClients() {
        int nextInt = scanner.nextInt();

        while (nextInt != -1) {
            int id = nextInt;
            boolean needToSkipCurrentClient = false;

            if (hasClientById(id)) {
                System.out.println("1:erro-numero repetido");
                needToSkipCurrentClient = true;
            }

            String name = scanner.nextLine();
            String email = scanner.nextLine();
            String cpf = scanner.nextLine();

            nextInt = scanner.nextInt();

            if (needToSkipCurrentClient) {
                continue;
            } else {
                Individual individualClient = new Individual(id, name, email, cpf);
                clients.add(individualClient);
                System.out.println("1:" + id + ";" + name + ";" + email + ";" + cpf);
            }
        }
    }

    private void registerCorporateClientes() {
        int nextInt = scanner.nextInt();

        while (nextInt != -1) {
            int id = nextInt;
            boolean needToSkipCurrentClient = false;

            if (hasClientById(id)) {
                System.out.println("2:erro-numero repetido");
                needToSkipCurrentClient = true;
            }

            String name = scanner.nextLine();
            String email = scanner.nextLine();
            String cnpj = scanner.nextLine();
            String businessName = scanner.nextLine();

            nextInt = scanner.nextInt();

            if (needToSkipCurrentClient) {
                continue;
            } else {
                Corporativo corporateClient = new Corporativo(id, name, email, cnpj, businessName);
                clients.add(corporateClient);
                System.out.println("2:" + id + ";" + name + ";" + email + ";" + cnpj + ";" + businessName);
            }
        }
    }

    private void registerGames() {
        int nextInt = scanner.nextInt();

        while (nextInt != -1) {
            int id = nextInt;

            if (hasClientById(id)) {
                System.out.println("3:erro-codigo repetido");
            }

            String name = scanner.nextLine();
            int year = scanner.nextInt();
            double valuePerMinute = scanner.nextDouble();
            Categoria categoryEnum = Categoria.valueOf(scanner.nextLine());
            String categoryDescription = categoryEnum.getDescription();

            nextInt = scanner.nextInt();

            if (categoryDescription == null) {
                System.out.println("3:erro-categoria inexistente");
                continue;
            }

            Jogo game = new Jogo(id, name, year, valuePerMinute, categoryEnum);
            games.add(game);
            System.out.println("3:" + id + ";" + name + ";" + year + ";" + valuePerMinute + ";" + categoryDescription);
        }
    }

    private void registerContracts() {
        int nextInt = scanner.nextInt();

        while (nextInt != -1) {
            int id = nextInt;

            if (hasContractById(id)) {
                System.out.println("4:erro-id repetido");
            }

            int periodOfDays = scanner.nextInt();
            int clientId = scanner.nextInt();

            if (!hasClientById(clientId)) {
                System.out.println("4:erro-cliente inexistente");
            }

            int gameId = scanner.nextInt();

            if (!hasGameById(gameId)) {
                System.out.println("4:erro-jogo inexistente");
            }

            nextInt = scanner.nextInt();

            Contrato contract = new Contrato(id, periodOfDays);
            this.contracts.add(contract);
            System.out.println("4:" + id + ";" + periodOfDays + ";" + clientId + ";" + gameId);
        }
    }

    private void readGameById(int id) {
        for (Jogo game : this.games) {
            if (game.getId() == id) {
                System.out.println("5:" + id + ";" + game.getName() + ";" + game.getCategory());
                return;
            }
        }

        System.out.println("5:erro-codigo inexistente");
    }

    private void readGamesByCategory(String category) {
        String categoryDescription = Categoria.valueOf(category).getDescription();

        if (categoryDescription == null) {
            System.out.println("6:erro-categoria inexistente.");
            return;
        }

        ArrayList<Jogo> games = getGamesByCategory(categoryDescription);

        if (games.size() == 0) {
            System.out.println("6:erro-nenhum jogo encontrado.");
            return;
        }

        for (Jogo game : games) {
            System.out.println("6:" + game.getCategory() + ";" + game.getId() + ";" + game.getName());
        }
    }

    private void updateClientNameById(int id, String newName) {
        for (Cliente client : this.clients) {
            if (client.getId() == id) {
                client.setName(newName);
                System.out.println("7:" + id + ";" + newName + ";" + client.getEmail());
                return;
            }
        }

        System.out.println("7:erro-numero inexistente.");
    }

    private void clearGameContractsById(int id) {
        for (Jogo game : this.games) {
            if (game.getId() == id) {
                if (game.getContracts().size() == 0) {
                    System.out.println("8:nenhum contrato encontrado.");
                    return;
                }

                for (Contrato contract : game.getContracts()) {
                    System.out.println("8:contrato removido: " + contract.getId());
                }

                game.clearContracts();
                return;
            }
        }

        System.out.println("8:erro-codigo inexistente.");
    }

    private void listContracts() {
    }

    private void readHighestContractValueClient() {
    }

    private void createFileIn() {
        try {
            BufferedReader streamInput = new BufferedReader(new FileReader(dataInFileName));
            scanner = new Scanner(streamInput);
        } catch (Exception error) {
            System.out.println("Erro ao criar leitor de entrada via arquivo: " + error);
        }
    }

    private void createFileOut() {
        try {
            PrintStream streamOut = new PrintStream(new File(dataOutFileName), Charset.forName("UTF-8"));
            System.setOut(streamOut);
        } catch (Exception error) {
            System.out.println(error);
        }

        Locale.setDefault(Locale.ENGLISH);
    }

    private boolean hasClientById(int id) {
        for (Cliente client : this.clients) {
            if (client.getId() == id) {
                return true;
            }
        }

        return false;
    }

    private boolean hasGameById(int id) {
        for (Jogo game : this.games) {
            if (game.getId() == id) {
                return true;
            }
        }

        return false;
    }

    private boolean hasContractById(int id) {
        for (Contrato contract : this.contracts) {
            if (contract.getId() == id) {
                return true;
            }
        }

        return false;
    }

    private ArrayList<Jogo> getGamesByCategory(String category) {
        ArrayList<Jogo> gamesByCategory = new ArrayList<>();

        for (Jogo game : this.games) {
            if (game.getCategory() == category) {
                gamesByCategory.add(game);
            }
        }

        return gamesByCategory;
    }
}
