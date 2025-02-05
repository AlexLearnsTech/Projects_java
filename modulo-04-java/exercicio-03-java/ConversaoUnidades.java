public class ConversaoUnidades {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double valor;
        String unidadeOrigem, unidadeDestino;
 
        while (true) {
            exibirMenu();
            System.out.print("\nDigite o valor: ");
            valor = scanner.nextDouble();
            scanner.nextLine();
 
            System.out.print("Digite a unidade de origem (ou 'sair' para encerrar): ");
            unidadeOrigem = scanner.nextLine().toLowerCase();
            
            if (unidadeOrigem.equals("sair")) {
                break;
            }
 
            System.out.print("Digite a unidade de destino: ");
            unidadeDestino = scanner.nextLine().toLowerCase();
 
            double resultado = converter(valor, unidadeOrigem, unidadeDestino);
            if (resultado != -1) {
                System.out.printf("%.2f %s = %.2f %s%n", 
                    valor, unidadeOrigem, resultado, unidadeDestino);
            }
            System.out.println();
        }
        scanner.close();
    }
 
    private static void exibirMenu() {
        System.out.println("=== Conversor de Unidades ===");
        System.out.println("Unidades disponíveis:");
        System.out.println("Comprimento: metros, centimetros, polegadas");
        System.out.println("Volume: litros, mililitros, quartos");
        System.out.println("Massa: quilogramas, gramas, libras");
    }
 
    private static double converter(double valor, String origem, String destino) {
        
        String categoria = identificarCategoria(origem);
        if (!categoria.equals(identificarCategoria(destino))) {
            System.out.println("Erro: Unidades incompatíveis!");
            return -1;
        }
 
        double valorBase = paraBase(valor, origem);
        
        return deBase(valorBase, destino);
    }
 
    private static String identificarCategoria(String unidade) {
        if (unidade.equals("metros") || unidade.equals("centimetros") || 
            unidade.equals("polegadas")) {
            return "comprimento";
        }
        if (unidade.equals("litros") || unidade.equals("mililitros") || 
            unidade.equals("quartos")) {
            return "volume";
        }
        if (unidade.equals("quilogramas") || unidade.equals("gramas") || 
            unidade.equals("libras")) {
            return "massa";
        }
        return "invalido";
    }
 
    private static double paraBase(double valor, String unidade) {
        switch (unidade) {
            
            case "metros": return valor;
            case "centimetros": return valor / 100;
            case "polegadas": return valor * 0.0254;
            
            case "litros": return valor;
            case "mililitros": return valor / 1000;
            case "quartos": return valor * 0.946353;
            
            case "quilogramas": return valor;
            case "gramas": return valor / 1000;
            case "libras": return valor * 0.453592;
            
            default: return -1;
        }
    }
 
    private static double deBase(double valor, String unidade) {
        switch (unidade) {
            // Comprimento (de metros)
            case "metros": return valor;
            case "centimetros": return valor * 100;
            case "polegadas": return valor / 0.0254;
            
            // Volume (de litros)
            case "litros": return valor;
            case "mililitros": return valor * 1000;
            case "quartos": return valor / 0.946353;
            
            // Massa (de quilogramas)
            case "quilogramas": return valor;
            case "gramas": return valor * 1000;
            case "libras": return valor / 0.453592;
            
            default: return -1;
        }
    }
 }