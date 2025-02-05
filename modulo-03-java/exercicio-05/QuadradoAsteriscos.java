import java.util.Scanner;

public class QuadradoAsteriscos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tamanho;
        
        do {
            System.out.print("Digite o tamanho do quadrado (1-20): ");
            tamanho = input.nextInt();
            
            if (tamanho < 1 || tamanho > 20) {
                System.out.println("Por favor, digite um número entre 1 e 20.");
            }
        } while (tamanho < 1 || tamanho > 20);
        
        for (int i = 0; i < tamanho; i++) {
            System.out.print("*");
        }
        System.out.println();
        
        for (int i = 0; i < tamanho - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < tamanho - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        
        if (tamanho > 1) {
            for (int i = 0; i < tamanho; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        input.close();
    }
}