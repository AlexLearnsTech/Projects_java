class IntegerHuge {
    private int[] numero;
    private boolean negativo;
 
    public IntegerHuge() {
        numero = new int[40];
        negativo = false;
    }
 
    public void parse(String str) {
        // Limpar array anterior
        for (int i = 0; i < numero.length; i++) {
            numero[i] = 0;
        }
 
        // Tratamento de sinal
        negativo = str.charAt(0) == '-';
        str = negativo ? str.substring(1) : str;
 
        // Conversão de caracteres para dígitos
        int j = numero.length - str.length();
        for (int i = 0; i < str.length(); i++) {
            numero[j + i] = Character.getNumericValue(str.charAt(i));
        }
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (negativo) sb.append("-");
 
        // Pular zeros iniciais
        int inicio = 0;
        while (inicio < numero.length && numero[inicio] == 0) {
            inicio++;
        }
 
        // Construir string
        if (inicio == numero.length) return "0";
        
        for (int i = inicio; i < numero.length; i++) {
            sb.append(numero[i]);
        }
        return sb.toString();
    }
 
    public IntegerHuge add(IntegerHuge outro) {
        IntegerHuge resultado = new IntegerHuge();
        int carry = 0;
 
        // Verificar sinais para adição/subtração
        if (this.negativo == outro.negativo) {
            for (int i = numero.length - 1; i >= 0; i--) {
                int soma = this.numero[i] + outro.numero[i] + carry;
                resultado.numero[i] = soma % 10;
                carry = soma / 10;
            }
            resultado.negativo = this.negativo;
        } else {
            // Implementação simplificada de adição com sinais diferentes
            resultado = this.isBiggerThan(outro) ? this.subtract(outro) : outro.subtract(this);
        }
        return resultado;
    }
 
    public IntegerHuge subtract(IntegerHuge outro) {
        IntegerHuge resultado = new IntegerHuge();
        boolean emprestar = false;
 
        for (int i = numero.length - 1; i >= 0; i--) {
            int diff = this.numero[i] - outro.numero[i];
            if (emprestar) {
                diff--;
                emprestar = false;
            }
 
            if (diff < 0) {
                diff += 10;
                emprestar = true;
            }
            resultado.numero[i] = diff;
        }
 
        return resultado;
    }
 
    public boolean isZero() {
        for (int digito : numero) {
            if (digito != 0) return false;
        }
        return true;
    }
 
    public boolean isEqualTo(IntegerHuge outro) {
        for (int i = 0; i < numero.length; i++) {
            if (this.numero[i] != outro.numero[i]) return false;
        }
        return true;
    }
 
    public boolean isBiggerThan(IntegerHuge outro) {
        for (int i = 0; i < numero.length; i++) {
            if (this.numero[i] > outro.numero[i]) return true;
            if (this.numero[i] < outro.numero[i]) return false;
        }
        return false;
    }
 
    public static void main(String[] args) {
        IntegerHuge num1 = new IntegerHuge();
        IntegerHuge num2 = new IntegerHuge();
 
        num1.parse("1234567890");
        num2.parse("9876543210");
 
        System.out.println("Número 1: " + num1);
        System.out.println("Número 2: " + num2);
 
        IntegerHuge soma = num1.add(num2);
        System.out.println("Soma: " + soma);
    }
 }