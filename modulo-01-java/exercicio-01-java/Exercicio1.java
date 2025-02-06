import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int numero1 = input.nextInt();

        System.out.print("Digite o segundo número: ");
        int numero2 = input.nextInt();

        System.out.println("\nResultados:");
        System.out.println("Soma: " + (numero1 + numero2));
        System.out.println("Produto: " + (numero1 * numero2));
        System.out.println("Diferença: " + (numero1 - numero2));
        
        if (numero2 != 0) {
            System.out.println("Quociente: " + ((double) numero1 / numero2));
        } else {
            System.out.println("Não é possível dividir por zero.");
        }

        input.close();
    }
}