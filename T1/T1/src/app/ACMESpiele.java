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
import dados.Corporativo;
import dados.Individual;

public class ACMESpiele {
    private final String dataInFileName = "datain.txt";
    private final String dataOutFileName = "dataout.txt";
    private ArrayList<Cliente> clients = new ArrayList<>();

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
        readGamesByCategori(Categoria.ADVENTURE);
        updateClientNameById(1, "Novo nome");
        clearGameContractsById(1);
        listContracts();
        readHighestContractValueClient();
    }

    private void registerIndividualClients() {
        int nextInt = scanner.nextInt();
        int counter = 1;

        while (nextInt != -1) {
            int id = nextInt;
            boolean needToSkipCurrentClient = false;

            if (hasClientById(id)) {
                System.out.println(counter + ":erro-numero repetido");
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
                System.out.println(counter + ":" + id + ";" + name + ";" + email + ";" + cpf);
                counter++;
            }
        }
    }

    private void registerCorporateClientes() {
        int nextInt = scanner.nextInt();
        int counter = 1;

        while (nextInt != -1) {
            int id = nextInt;
            boolean needToSkipCurrentClient = false;

            if (hasClientById(id)) {
                System.out.println(counter + ":erro-numero repetido");
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
                System.out.println(counter + ":" + id + ";" + name + ";" + email + ";" + cnpj + ";" + businessName);
                counter++;
            }
        }
    }

    private void registerGames() {
    }

    private void registerContracts() {
    }

    private void readGameById() {
    }

    private void readGamesByCategori(Categoria category) {
    }

    private void updateClientNameById(int id, String newName) {
    }

    private void clearGameContractsById(int id) {
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
}
