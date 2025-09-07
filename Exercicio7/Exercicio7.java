public class Exercicio7 {
    private static int contador = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("5 threads incrementando contador 1000 vezes cada");
        System.out.println("Executando...\n");

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            final int threadId = i + 1;

            threads[i] = new Thread(() -> {
                System.out.println("Thread " + threadId + " iniciada");

                for (int j = 0; j < 1000; j++) {
                    synchronized (lock) {
                        contador++;
                    }
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
    }
}
