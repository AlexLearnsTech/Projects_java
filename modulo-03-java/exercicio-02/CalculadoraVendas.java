import java.util.Scanner;

public class CalculadoraVendas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalVendas = 0.0;

        final double PRECO1 = 2.98;
        final double PRECO2 = 4.50;
        final double PRECO3 = 9.98;
        final double PRECO4 = 4.49;
        final double PRECO5 = 6.87;

        System.out.println("Calculadora de Vendas");
        System.out.println("Produtos disponíveis:");
        System.out.println("1 - R$ 2,98");
        System.out.println("2 - R$ 4,50");
        System.out.println("3 - R$ 9,98");
        System.out.println("4 - R$ 4,49");
        System.out.println("5 - R$ 6,87");
        System.out.println("Digite -1 no número do produto para encerrar\n");

        while (true) {
            System.out.print("Digite o número do produto (1-5): ");
            int produto = input.nextInt();

            if (produto == -1) {
                break;
            }

            if (produto < 1 || produto > 5) {
                System.out.println("Produto inválido. Por favor, digite um número entre 1 e 5.");
                continue;
            }

            System.out.print("Digite a quantidade vendida: ");
            int quantidade = input.nextInt();

            if (quantidade <= 0) {
                System.out.println("Quantidade inválida. Por favor, digite um número positivo.");
                continue;
            }

            double valorVenda = 0.0;
            switch (produto) {
                case 1:
                    valorVenda = PRECO1 * quantidade;
                    break;
                case 2:
                    valorVenda = PRECO2 * quantidade;
                    break;
                case 3:
                    valorVenda = PRECO3 * quantidade;
                    break;
                case 4:
                    valorVenda = PRECO4 * quantidade;
                    break;
                case 5:
                    valorVenda = PRECO5 * quantidade;
                    break;
            }

            totalVendas += valorVenda;
            System.out.printf("Valor desta venda: R$ %.2f%n%n", valorVenda);
        }

        System.out.printf("%nTotal de todas as vendas: R$ %.2f%n", totalVendas);
        input.close();
    }
}