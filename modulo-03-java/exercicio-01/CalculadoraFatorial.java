public class CalculadoraFatorial {
    public static void main(String[] args) {
        System.out.println("Número  | Fatorial");
        System.out.println("------- |--------");
        
        for (int i = 1; i <= 20; i++) {
            long fatorial = calcularFatorial(i);
            System.out.printf("%7d | %d%n", i, fatorial);
            
            if (fatorial < 0) {
                System.out.println("\nAviso: Overflow detectado no fatorial de " + i);
                System.out.println("Os valores após este ponto não são confiáveis.");
                break;
            }
        }
        System.out.println("\nLimitações para calcular fatorial de 100:");
        System.out.println("1. O tipo long em Java tem limite máximo de 2^63 - 1");
        System.out.println("2. O fatorial de 100 tem aproximadamente 158 dígitos");
        System.out.println("3. Para calcular fatorial de 100, seria necessário usar:");
        System.out.println("   - BigInteger para cálculos exatos");
        System.out.println("   - Double para aproximação científica");
    }

    private static long calcularFatorial(int n) {
        if (n <= 1) return 1;
        
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}