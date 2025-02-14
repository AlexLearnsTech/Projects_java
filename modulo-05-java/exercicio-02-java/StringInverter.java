public class StringInverter {
    public static void stringInverse(char[] str) {
        stringInverse(str, str.length - 1);
        
        System.out.println();
    }
    
    private static void stringInverse(char[] str, int index) {
        
        if (index < 0) {
            return;
        }
        System.out.print(str[index]);
        stringInverse(str, index - 1);
    }
    
    public static void main(String[] args) {
        String texto = "Hello World";
        char[] array = texto.toCharArray();
        
        System.out.println("String original: " + texto);
        System.out.print("String invertida: ");
        stringInverse(array);
    }
}