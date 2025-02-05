public class tempCodeRunnerFile {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int[] numeros = new int[5];
        int qtdNumeros = 0;

        System.out.println("Digite 5 números entre 10 e 100:");

        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            int numero = scanner.nextInt();

            if (numero < 10 || numero > 100) {
                System.out.println("Por favor, digite um número entre 10 e 100.");
                i--;
                continue;
            }

            boolean duplicado = false;
            for (int j = 0; j < qtdNumeros; j++) {
                if (numeros[j] == numero) {
                    duplicado = true;
                    break;
                }
            }

            if (!duplicado) {
                numeros[qtdNumeros] = numero;
                qtdNumeros++;
            }

            System.out.print("Números únicos até agora: ");
            for (int j = 0; j < qtdNumeros; j++) {
                System.out.print(numeros[j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
