public class ArrayPrinter {
    public static void printArray(int[] array) {
        printArray(array, 0);
        
        System.out.println();
    }
    
    private static void printArray(int[] array, int index) {

        if (index >= array.length) {
            return;
        }
        
        System.out.print(array[index] + " ");
        
        printArray(array, index + 1);
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Elementos do array:");
        printArray(array);
    }
} 