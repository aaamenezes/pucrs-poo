package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

import dados.Categoria;

public class ACMESpiele {
    private final String dataInFileName = "datain.txt";
    private final String dataOutFileName = "dataout.txt";

    private Scanner scanner = new Scanner(System.in);

    public ACMESpiele() {
        createFileIn();
        createFileOut();
    }

    public void exec() {
        String line = "";

        line = scanner.nextLine();
        line = scanner.nextLine();
        while (!line.equals("-1")) {
            System.out.println("próxima linha: " + line);
        }

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
    }

    private void registerCorporateClientes() {
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
}
