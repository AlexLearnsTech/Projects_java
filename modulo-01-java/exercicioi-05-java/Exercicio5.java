import java.util.Locale;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Digite seu peso em kg: ");
        double peso = sc.nextDouble();
        
        System.out.print("Digite sua altura em metros: ");
        double altura = sc.nextDouble();
        
        double imc = peso / (altura * altura);
        
        System.out.printf("\nSeu IMC é %.1f\n", imc);
        
        if (imc < 18.5) {
            System.out.println("Classificação: Abaixo do peso");
        } else if (imc < 25) {
            System.out.println("Classificação: Peso normal");
        } else if (imc < 30) {
            System.out.println("Classificação: Sobrepeso");
        } else if (imc < 35) {
            System.out.println("Classificação: Obesidade grau 1");
        } else if (imc < 40) {
            System.out.println("Classificação: Obesidade grau 2");
        } else {
            System.out.println("Classificação: Obesidade grau 3");
        }
        
        System.out.println("\nCategorias de IMC:");
        System.out.println("Abaixo do peso: < 18.5");
        System.out.println("Peso normal: 18.5 - 24.9");
        System.out.println("Sobrepeso: 25 - 29.9");
        System.out.println("Obesidade grau 1: 30 - 34.9");
        System.out.println("Obesidade grau 2: 35 - 39.9");
        System.out.println("Obesidade grau 3: ≥ 40");

        sc.close();
    }
}
