public class Soma {
    public static void main(String[] args) {
        long tempoInicio = System.currentTimeMillis();
        
        int result = 0;
        int iterations = 0;

        int min = 1;
        int max = 100000;
        
        for (int i = min; i < max+1; i++) {
            result += i;
            iterations++;
        }
        
        long tempoFim = System.currentTimeMillis();
        long duracao = tempoFim - tempoInicio; // Tempo em nanossegundos

        System.out.println("Resultado: " + result);
        System.out.println("Duração: " + duracao + " milissegundos");
        System.out.println("Iterações: " + iterations);

        // f1(n): 5n
        // O(n): linear
    }
}
