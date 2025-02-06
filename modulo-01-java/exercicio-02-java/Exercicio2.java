import java.util.Scanner;

public class Exercicio2 {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       System.out.print("Digite o primeiro número: ");
       int numero1 = input.nextInt();

       System.out.print("Digite o segundo número: ");
       int numero2 = input.nextInt();

       if (numero1 > numero2) {
           System.out.println(numero1 + " é maior");
       } else if (numero2 > numero1) {
           System.out.println(numero2 + " é maior");
       } else {
           System.out.println("Esses números são iguais");
       }

       input.close();
   }
}