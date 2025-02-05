import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FatoresPrimos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int num = scanner.nextInt();
        scanner.close();

        if (isPrime(num)) {
            System.out.println("O número " + num + " é primo.");
        } else {
            System.out.print("O número " + num + " não é primo.\nFatores primos exclusivos: ");
            Set<Integer> fatoresPrimos = getUniquePrimeFactors(num);
            System.out.println(fatoresPrimos);
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static Set<Integer> getUniquePrimeFactors(int n) {
        Set<Integer> fatores = new TreeSet<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                fatores.add(i);
                n /= i;
            }
        }
        return fatores;
    }
}
