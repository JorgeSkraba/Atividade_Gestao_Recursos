import java.util.concurrent.Semaphore;
import java.util.Random;

public class Main {
    static final int Item = 10;

     public static class Buffer {
        int item;
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Semaphore semvazio = new Semaphore(1);
        Semaphore semcheio = new Semaphore(0);
        Random rand = new Random();

        Thread produtor = new Thread(() -> {
            for (int i = 0; i < Item; i++) {
                try {
                    int item = rand.nextInt(100) + 1;
                    semvazio.acquire();
                    buffer.item = item;
                    System.out.println("Produtor produziu" + item);
                    semcheio.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumidor = new Thread(() -> {
            for (int i = 0; i < Item; i++) {
                try {
                    semcheio.acquire();
                    int item = buffer.item;
                    System.out.println("Consumidor consumiu" + item);
                    semvazio.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        produtor.start();
        consumidor.start();

        try {
            produtor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
