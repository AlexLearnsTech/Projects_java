import java.util.Scanner;

public class InverterDigitos {

    public static int inverter(int numero) {
        int invertido = 0;

        while (numero != 0) {
            int digito = numero % 10;
            invertido = invertido * 10 + digito;
            numero /= 10;
        }
        return invertido;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro para inverter: ");
        int numero = scanner.nextInt();

        int numeroInvertido = inverter(numero);
        System.out.println("Número invertido: " + numeroInvertido);

        scanner.close();
    }
}
