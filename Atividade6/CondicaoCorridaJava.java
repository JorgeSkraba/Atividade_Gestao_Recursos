public class CondicaoCorridaJava {
        private static int contador = 0;

        public static void main(String[] args) {
            System.out.println("5 threads incrementando contador 1000 vezes cada");
            System.out.println("Executando...\n");

            // Array para armazenar as 5 threads
            Thread[] threads = new Thread[5];

            // Cria e inicia 5 threads
            for (int i = 0; i < 5; i++) {
                final int threadId = i + 1;

                threads[i] = new Thread(() -> {
                    System.out.println("Thread " + threadId + " iniciada");

                    for (int j = 0; j < 1000; j++) {
                        contador++;
                    }

                    System.out.println("Thread " + threadId + " terminou");
                });

                threads[i].start();
            }

            try {
                for (Thread t : threads) {
                    t.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\n=== RESULTADOS ===");
            System.out.println("Valor final do contador: " + contador);
            System.out.println("Valor esperado: 5000");

            if (contador == 5000) {
                System.out.println("Resultado correto (sorte ou poucas threads)");
            } else {
                System.out.println("Race condition ocorreu! Perdemos " + (5000 - contador) + " incrementos");
            }

            System.out.println("\n=== EXPLICAÇÃO ===");
            System.out.println("A operação 'contador++' não-atômica (leitura-modificação-escrita)!");
            System.out.println("Múltiplas threads podem interferir umas nas outras.");
        }
}
