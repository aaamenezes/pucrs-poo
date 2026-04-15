package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class ACMESpiele {
    private final String dataInFileName = "datain.txt";
    // private final String nomeArquivoSaida = "dataout.txt";

    private Scanner scanner = new Scanner(System.in);

    public ACMESpiele() {
        createFileIn();
    }

    public void exec() {
        String line = "";

        line = scanner.nextLine();
        line = scanner.nextLine();
        while (!line.equals("-1")) {
            System.out.println("próxima linha: " + line);
        }
    }

    private void createFileIn() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(dataInFileName));
            scanner = new Scanner(streamEntrada);
        } catch (Exception error) {
            System.out.println("Erro ao criar leitor de entrada via arquivo: " + error);
        }
    }
}
