import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final int NUM_PROCESSES = 3;
    public static void main(String[] args) {
        System.out.println("Processo Pai (PID: "+ ProcessHandle.current().pid()+")");

        for (int i = 0; i < NUM_PROCESSES; i++) {
            try {
                //criação do novo processo
                ProcessBuilder processo = new ProcessBuilder("notepad");

                Process p = processo.start();
                System.out.println("Pai: criado Processo Filho "+ (i+1) + "(PID: "+p.pid()+")");

                //caso ocorra erro na criação
            }catch (IOException e){
                System.out.println("Pai: Erro ao criar o processo filho "+ (i+1) +": "+ e.getMessage());
                return;
            }
        }
        System.out.println("Pai: Todos os filhos lançados. Terminando.");
        new Scanner(System.in).nextLine();
    }
}