import java.util.Scanner;

public class ConversorBinarioDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.print("Digite um número binário (apenas 0s e 1s): ");
            int numeroBinario = input.nextInt();
            
            if (!ehBinarioValido(numeroBinario)) {
                System.out.println("Erro: Digite apenas números contendo 0s e 1s.");
                continue;
            }
            int numeroDecimal = 0;
            int numeroOriginal = numeroBinario;
            int valorPosicional = 1;
            
            while (numeroBinario > 0) {
                int digito = numeroBinario % 10;
                numeroDecimal += digito * valorPosicional;
                valorPosicional *= 2;
                numeroBinario /= 10;
            }
            
            System.out.printf("O número binário %d em decimal é: %d%n", 
                            numeroOriginal, numeroDecimal);
            
            System.out.print("Deseja converter outro número? (1 para Sim, 0 para Não): ");
            if (input.nextInt() != 1) break;
        }
        
        input.close();
    }
    
    private static boolean ehBinarioValido(int numero) {
        while (numero > 0) {
            int digito = numero % 10;
            if (digito != 0 && digito != 1) {
                return false;
            }
            numero /= 10;
        }
        return true;
    }
}