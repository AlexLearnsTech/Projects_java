import java.util.*;
import java.io.FileNotFoundException;

public class PhoneWordGeneratorFile {
    
    private static final Map<Character, String> digitToLetters = new HashMap<>();
    private static final Map<Character, Character> letterToDigit = new HashMap<>();
    
    static {
        
        digitToLetters.put('2', "ABC");
        digitToLetters.put('3', "DEF");
        digitToLetters.put('4', "GHI");
        digitToLetters.put('5', "JKL");
        digitToLetters.put('6', "MNO");
        digitToLetters.put('7', "PQRS");
        digitToLetters.put('8', "TUV");
        digitToLetters.put('9', "WXYZ"); 
        
        for (Map.Entry<Character, String> entry : digitToLetters.entrySet()) {
            char digit = entry.getKey();
            String letters = entry.getValue();
            for (char letter : letters.toCharArray()) {
                letterToDigit.put(letter, digit);
            }
        }
    }
    private static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 7) {
            return false;
        }
        for (char digit : phoneNumber.toCharArray()) {
            if (digit < '2' || digit > '9') {
                return false;
            }
        }
        return true;
    }
    
    public static void generateWordsToFile(String phoneNumber, String fileName) {
        try (Formatter output = new Formatter(fileName)) {
            if (!isValidPhoneNumber(phoneNumber)) {
                throw new IllegalArgumentException(
                    "Número de telefone inválido. Use apenas dígitos de 2-9 e exatamente 7 dígitos.");
            }
            
            output.format("Combinações para o número %s:%n", phoneNumber);
            output.format("(Agora incluindo as letras Q e Z no mapeamento)%n%n");
            
            Counter counter = new Counter();
            generateWords(phoneNumber, 0, "", output, counter);
            
            output.format("%nTotal de combinações geradas: %d%n", counter.value);
            
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }
    
    private static class Counter {
        int value = 0;
    }
    private static void generateWords(String phoneNumber, int position, 
                                    String currentWord, Formatter output, Counter counter) {
        if (position == phoneNumber.length()) {
            output.format("%s%n", currentWord);
            counter.value++;
            return;
        }
        
        char digit = phoneNumber.charAt(position);
        String letters = digitToLetters.get(digit);
        
        for (char letter : letters.toCharArray()) {
            generateWords(phoneNumber, position + 1, currentWord + letter, output, counter);
        }
    }
    
    public static void main(String[] args) {
        
        String[] phoneNumbers = {
            "6862377", // NUMBERS
            "4247288", // HAIRCUT
            "7382273", // PETCARE
            "6392277", // NEWCARS
            
        };
        
        for (String phoneNumber : phoneNumbers) {
            String fileName = "combinations_" + phoneNumber + ".txt";
            System.out.println("Gerando combinações para " + phoneNumber);
            
            try {
                generateWordsToFile(phoneNumber, fileName);
                System.out.println("Arquivo " + fileName + " gerado com sucesso!");
                
                switch (phoneNumber) {
                    case "6862377":
                        System.out.println("Inclui a palavra NUMBERS");
                        break;
                    case "4247288":
                        System.out.println("Inclui a palavra HAIRCUT");
                        break;
                    case "7382273":
                        System.out.println("Inclui a palavra PETCARE");
                        break;
                    case "6392277":
                        System.out.println("Inclui a palavra NEWCARS");
                        break;
                    
                }
                System.out.println("------------------------");
                
            } catch (IllegalArgumentException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }
}