public class CodigoMorseConversor {
    private static final String[] LETRAS = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", 
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
    };
    
    private static final String[] MORSE = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
        "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--",
        "....-", ".....", "-....", "--...", "---..", "----.", "-----"
    };
 
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Tradutor de Código Morse ===");
            System.out.println("1. Português para Morse");
            System.out.println("2. Morse para Português");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            
            if (opcao == 3) {
                System.out.println("Programa encerrado!");
                break;
            }
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o texto em português: ");
                    String texto = scanner.nextLine();
                    System.out.println("Em Morse: " + codificarParaMorse(texto));
                    break;
                    
                case 2:
                    System.out.println("Digite o código Morse (use espaço entre letras e três espaços entre palavras):");
                    String morse = scanner.nextLine();
                    System.out.println("Em português: " + decodificarDeMorse(morse));
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
 
    private static String codificarParaMorse(String texto) {
        StringBuilder morse = new StringBuilder();
        texto = texto.toUpperCase();
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            
            if (c == ' ') {
                morse.append("   ");
                continue;
            }
            
            for (int j = 0; j < LETRAS.length; j++) {
                if (LETRAS[j].charAt(0) == c) {
                    morse.append(MORSE[j]);
                    morse.append(" ");
                    break;
                }
            }
        }
        return morse.toString().trim();
    }
 
    private static String decodificarDeMorse(String morse) {
        StringBuilder texto = new StringBuilder();
        String[] palavras = morse.split("   ");
        
        for (String palavra : palavras) {
            String[] letras = palavra.split(" ");
            
            for (String letra : letras) {
            
                for (int i = 0; i < MORSE.length; i++) {
                    if (MORSE[i].equals(letra)) {
                        texto.append(LETRAS[i]);
                        break;
                    }
                }
            }
            texto.append(" ");
        }
        return texto.toString().trim();
    }
 }