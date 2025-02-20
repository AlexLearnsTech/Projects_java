class BaseException extends Exception {
    public BaseException(String message) {
        super(message);
    }
}

class DerivedException extends BaseException {
    public DerivedException(String message) {
        super(message);
    }
}

public class CatchOrderDemo {
    // Método que demonstra a ordem correta dos blocos catch
    public static void demonstrarOrdemCorreta() {
        System.out.println("Demonstração com ordem correta dos blocos catch:");
        try {
            // Lança uma exceção derivada
            throw new DerivedException("Exceção específica lançada");
        } catch (DerivedException e) {
            // Captura a exceção mais específica
            System.out.println("1. Capturado em DerivedException: " + e.getMessage());
        }
    }

    // Método que demonstra a ordem incorreta dos blocos catch
    // Este código NÃO COMPILARÁ
    /*
    public static void demonstrarOrdemIncorreta() {
        System.out.println("\nDemonstração com ordem incorreta dos blocos catch:");
        try {
            throw new DerivedException("Exceção específica lançada");
        } catch (BaseException e) {     // ERRO: Captura primeiro a exceção base
            System.out.println("1. Capturado em BaseException: " + e.getMessage());
        } catch (DerivedException e) {  // ERRO: Nunca será alcançado
            System.out.println("2. Capturado em DerivedException: " + e.getMessage());
        }
    }
    */

    // Método que demonstra múltiplos tipos de exceções
    public static void demonstrarMultiplasExcecoes() {
        System.out.println("\nDemonstração com múltiplos tipos de exceções:");
        try {
            // Escolhe aleatoriamente qual exceção lançar
            if (Math.random() < 0.5) {
                throw new DerivedException("Exceção derivada lançada");
            } else {
                throw new BaseException("Exceção base lançada");
            }
        } catch (DerivedException e) {
            System.out.println("1. Capturado em DerivedException: " + e.getMessage());
        } catch (BaseException e) {
            System.out.println("2. Capturado em BaseException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        demonstrarOrdemCorreta();
        // O método demonstrarOrdemIncorreta está comentado pois não compilaria
        demonstrarMultiplasExcecoes();
        demonstrarMultiplasExcecoes();  // Chama duas vezes para ver diferentes resultados
    }
}
