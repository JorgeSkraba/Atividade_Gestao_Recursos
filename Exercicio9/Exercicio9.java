public class Exercicio9 {

    public static void main(String[] args) throws InterruptedException {
        int numThreads = 4;
        int tamanhoRangeThreads = 1000000 / numThreads;

        Thread[] threads = new Thread[numThreads];
        long[] resultadosParciais = new long[numThreads];

        // Criação e execução das threads
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            int inicio = (i * tamanhoRangeThreads) + 1;
            int fim = (i == numThreads - 1) ? 1000000 : (i + 1) * tamanhoRangeThreads;

            threads[i] = new Thread(() -> {
                long somaLocal = 0;
                for (int j = inicio; j <= fim; j++) {
                    somaLocal += j;
                }
                resultadosParciais[threadId] = somaLocal;
            });

            threads[i].start();
        }

        // Espera e soma dos resultados
        long somaTotal = 0;
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
            somaTotal += resultadosParciais[i];
        }

        System.out.println("Soma total = " + somaTotal);
    }
}
