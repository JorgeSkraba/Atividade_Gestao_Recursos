import java.util.ArrayList;

public class Main {
    static final int numeros = 1000000;

    public static class MeuRecord {
        int id;
        byte[] data = new byte[100];
    }
    public static void main(String[] args) {
        long Comeca = System.currentTimeMillis();
        for (int i = 0; i < numeros; i++) {
            MeuRecord meurecord = new MeuRecord();
            meurecord.id = i;
        }
        long fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - Comeca) + " ms");
    }
}
