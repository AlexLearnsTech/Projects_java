import java.util.Scanner;

public class Exercicio4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int n = sc.nextInt();
        System.out.println(n % 2 == 0 ? "Par" : "Ímpar");

        sc.close();
    }
}