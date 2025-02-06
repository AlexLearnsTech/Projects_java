import java.util.Scanner;

public class Exercicio3 {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       System.out.print("Digite o 1º número: ");
       int n1 = input.nextInt();
       
       System.out.print("Digite o 2º número: ");
       int n2 = input.nextInt();
       
       System.out.print("Digite o 3º número: ");
       int n3 = input.nextInt();
       
       System.out.print("Digite o 4º número: ");
       int n4 = input.nextInt();
       
       System.out.print("Digite o 5º número: ");
       int n5 = input.nextInt();
       
       int maior = n1;
       int menor = n1;
       
       if (n2 > maior) maior = n2;
       if (n3 > maior) maior = n3;
       if (n4 > maior) maior = n4;
       if (n5 > maior) maior = n5;
       
       if (n2 < menor) menor = n2;
       if (n3 < menor) menor = n3;
       if (n4 < menor) menor = n4;
       if (n5 < menor) menor = n5;
       
       System.out.println("\nMaior número: " + maior);
       System.out.println("Menor número: " + menor);
       
       input.close();
   }
}