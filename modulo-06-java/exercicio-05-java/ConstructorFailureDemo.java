public class ConstructorFailureDemo {
    public static void main(String[] args) {
        try {
            new oneClass();
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
    }
}
class aClass {
    public aClass() throws Exception {
        throw new Exception("Falha no construtor de aClass.");
    }
}
class oneClass extends aClass {
    public oneClass() throws Exception {
        super();
    }
}
