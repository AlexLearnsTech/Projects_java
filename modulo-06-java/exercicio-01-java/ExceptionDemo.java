class ExceptionA extends Exception {
    public ExceptionA() {
        super("Exceção A");
    }
    
    public ExceptionA(String message) {
        super(message);
    }
}

class ExceptionB extends ExceptionA {
    public ExceptionB() {
        super("Exceção B");
    }
    
    public ExceptionB(String message) {
        super(message);
    }
}

class ExceptionC extends ExceptionB {
    public ExceptionC() {
        super("Exceção C");
    }
    
    public ExceptionC(String message) {
        super(message);
    }
}

public class ExceptionDemo {

    public static void throwExceptionB() throws ExceptionB {
        throw new ExceptionB("Lançando ExceptionB");
    }
    
    public static void throwExceptionC() throws ExceptionC {
        throw new ExceptionC("Lançando ExceptionC");
    }
    public static void main(String[] args) {

        try {
            System.out.println("Tentando lançar ExceptionB...");
            throwExceptionB();
        } catch (ExceptionA e) {
            System.out.println("Capturada: " + e.getMessage());
            System.out.println("Tipo da exceção: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n------------------------\n");
        
        try {
            System.out.println("Tentando lançar ExceptionC...");
            throwExceptionC();
        } catch (ExceptionA e) {
            System.out.println("Capturada: " + e.getMessage());
            System.out.println("Tipo da exceção: " + e.getClass().getSimpleName());
        }
    }
}