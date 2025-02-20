public class ExceptionRethrowing {
    
    public static void unMethod() throws Exception {
        try {
            System.out.println("unMethod: Chamando unMethod2()");
            unMethod2();
        } catch (Exception e) {
            System.out.println("unMethod: Capturou a exceção e vai relançá-la");
            throw e; 
        }
    }
    public static void unMethod2() throws Exception {
        System.out.println("unMethod2: Lançando exceção");
        throw new Exception("Exceção original lançada em unMethod2");
    }
    public static void main(String[] args) {
        try {
            System.out.println("main: Chamando unMethod()");
            unMethod();
        } catch (Exception e) {
            System.out.println("\nmain: Capturou a exceção relançada");
            System.out.println("\nMensagem da exceção:");
            System.out.println(e.getMessage());
            
            System.out.println("\nRastreamento completo da pilha:");
            e.printStackTrace();
        }
    }
}
