public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {60, 40, 30, 50, 20, 10, 70};

        System.out.println("Matriz original:");
        imprimirMatriz(arr);

        bubbleSort(arr);

        System.out.println("\nMatriz ordenada:");
        imprimirMatriz(arr);
    }

    public static void imprimirMatriz(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}