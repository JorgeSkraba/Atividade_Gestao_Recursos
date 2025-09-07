import java.util.Scanner;

public class DinamicaArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] meuArray = null;

        try {
            System.out.print("Digite o tamanho do array: ");
            int tamanho = scanner.nextInt();

            if (tamanho <= 0) {
                System.out.println("Erro: O tamanho deve ser um número positivo!");
                return;
            }

            meuArray = new int[tamanho];

            for (int i = 0; i < tamanho; i++) {
                meuArray[i] = i + 1;
            }

            System.out.println("Conteúdo do array:");
            for (int i = 0; i < meuArray.length; i++) {
                System.out.println(meuArray[i]);
            }

        } catch (OutOfMemoryError e) {
            System.out.println("Erro: Não foi possível alocar memória para o array!");
        } catch (Exception e) {
            System.out.println("Erro na entrada: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Programa finalizado. Memória será liberada automaticamente.");
    }
}
