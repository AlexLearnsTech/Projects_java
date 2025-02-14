public class MinimumFinder {
    public static int minimoRecursive(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array não pode ser nulo ou vazio");
        }
        
        if (array.length == 1) {
            return array[0];
        }
        
        return minimoRecursive(array, 0, array.length - 1);
    }
    private static int minimoRecursive(int[] array, int inicio, int fim) {
        if (inicio == fim) {
            return array[inicio];
        }
        
        int meio = (inicio + fim) / 2;
        
        int minEsquerda = minimoRecursive(array, inicio, meio);
        int minDireita = minimoRecursive(array, meio + 1, fim);
        
        return Math.min(minEsquerda, minDireita);
    }
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Array: " + java.util.Arrays.toString(array));
        System.out.println("Menor elemento: " + minimoRecursive(array));
    }
}