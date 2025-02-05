import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero;
        
        do {
            System.out.print("Digite um número de 5 dígitos: ");
            numero = input.nextInt();
            
            if (numero < 10000 || numero > 99999) {
                System.out.println("Erro: Por favor digite um número de exatamente 5 dígitos.");
                continue;
            }
            
            int digito1 = numero / 10000;          
            int digito2 = (numero / 1000) % 10;    
            int digito4 = (numero / 10) % 10;    
            int digito5 = numero % 10;             
            
            if (digito1 == digito5 && digito2 == digito4) {
                System.out.printf("%d é um palíndromo!%n", numero);
            } else {
                System.out.printf("%d não é um palíndromo.%n", numero);
            }
            
            System.out.print("Deseja verificar outro número? (1 para Sim, 0 para Não): ");
        } while (input.nextInt() == 1);
        
        input.close();
    }
}