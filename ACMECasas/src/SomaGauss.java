public class SomaGauss {
    public static void main(String[] args) {
        long tempoInicio = System.currentTimeMillis();
        
        int result = 0;
        int iterations = 0;

        int min = 1;
        int max = 10;
        
        result = ((min + max) * max) / 2;
        
        long tempoFim = System.currentTimeMillis();
        long duracao = tempoFim - tempoInicio; // Tempo em nanossegundos

        System.out.println("Resultado: " + result);
        System.out.println("Duração: " + duracao/1000.0 + " segundos");
        System.out.println("Iterações: " + iterations);

        // f2(n): 4
        // O(1): constante
    }
}
