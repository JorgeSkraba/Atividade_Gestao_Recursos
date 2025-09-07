// Classe para representar o worker thread
class TMyWorkerThread extends Thread {
    private int threadID;

    // Construtor
    public TMyWorkerThread(int threadID) {
        this.threadID = threadID;
        // Thread criada mas não iniciada ainda
    }

    // Método que será executado pela thread
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            // Verifica se a thread foi interrompida
            if (isInterrupted()) {
                break;
            }

            // Espera 0.5 segundos (500 milissegundos)
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Se foi interrompida durante o sleep
                break;
            }

            // Imprime a mensagem
            System.out.println("Thread " + threadID + ": Contagem " + i);
        }

        // Mensagem de finalização
        System.out.println("Thread " + threadID + ": Terminou.");
    }
}

// Classe principal
public class ThreadsJava {
    public static void main(String[] args) {
        System.out.println("=== PROGRAMA COM 3 THREADS ===");
        System.out.println("Thread principal: Iniciando...");

        // Cria as 3 threads
        TMyWorkerThread thread1 = new TMyWorkerThread(1);
        TMyWorkerThread thread2 = new TMyWorkerThread(2);
        TMyWorkerThread thread3 = new TMyWorkerThread(3);

        // Inicia as threads
        System.out.println("Thread principal: Iniciando as 3 threads...");
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Thread principal espera todas terminarem
            System.out.println("Thread principal: Aguardando threads terminarem...");
            thread1.join(); // Espera thread 1 terminar
            thread2.join(); // Espera thread 2 terminar
            thread3.join(); // Espera thread 3 terminar

        } catch (InterruptedException e) {
            System.out.println("Thread principal foi interrompida!");
        }

        // Mensagem final
        System.out.println("Thread principal: Todas as threads terminaram. Finalizando programa.");
    }
}