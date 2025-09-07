import java.util.ArrayList;
import java.util.Scanner;

public class VazamentoMemoria {
        public static void main(String[] args) {
                ArrayList<byte[]> listaBlocos = new ArrayList<byte[]>();
                int Contador = 0;
                Scanner scanner = new Scanner(System.in);

                // Mensagens iniciais
                System.out.println("Simulando vazamento de memoria. Observe o consumo no Gerenciador de Tarefas.");
                System.out.println("Pressione Ctrl+C para parar.");

                try {
                        while (true) {
                                byte[] P = new byte[1024];

                                listaBlocos.add(P);

                                Contador++;

                                if ((Contador % 1000) == 0) {
                                        System.out.println("Blocos alocados: " + Contador);
                                }
                        }
                } catch (OutOfMemoryError e) {
                        System.out.println("Falha ao alocar memoria. Provavelmente sem memoria disponivel.");
                }

                System.out.println("Pressione Enter para sair...");
                scanner.nextLine();
                scanner.close();
        }
}