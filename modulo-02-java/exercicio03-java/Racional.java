class Racional {
    private int numerador;
    private int denominador;
 
    public Racional() {
        this.numerador = 0;
        this.denominador = 1;
    }
 
    public Racional(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("Denominador não pode ser zero");
        }
 
        int sinal = (numerador * denominador >= 0) ? 1 : -1;
        numerador = Math.abs(numerador);
        denominador = Math.abs(denominador);
 
        int mdc = calcularMDC(numerador, denominador);
        this.numerador = sinal * (numerador / mdc);
        this.denominador = denominador / mdc;
    }
 
    private static int calcularMDC(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
 
    public static Racional adicionar(Racional r1, Racional r2) {
        int novoNumerador = r1.numerador * r2.denominador + r2.numerador * r1.denominador;
        int novoDenominador = r1.denominador * r2.denominador;
        return new Racional(novoNumerador, novoDenominador);
    }
 
    public static Racional subtrair(Racional r1, Racional r2) {
        int novoNumerador = r1.numerador * r2.denominador - r2.numerador * r1.denominador;
        int novoDenominador = r1.denominador * r2.denominador;
        return new Racional(novoNumerador, novoDenominador);
    }
 
    public static Racional multiplicar(Racional r1, Racional r2) {
        int novoNumerador = r1.numerador * r2.numerador;
        int novoDenominador = r1.denominador * r2.denominador;
        return new Racional(novoNumerador, novoDenominador);
    }
 
    public static Racional dividir(Racional r1, Racional r2) {
        int novoNumerador = r1.numerador * r2.denominador;
        int novoDenominador = r1.denominador * r2.numerador;
        return new Racional(novoNumerador, novoDenominador);
    }
 
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
 
    public String toDecimal(int precisao) {
        double valorDecimal = (double) numerador / denominador;
        return String.format("%." + precisao + "f", valorDecimal);
    }
 
    public String toDecimal() {
        return toDecimal(2);
    }
 
    public int getNumerador() { return numerador; }
    public int getDenominador() { return denominador; }
 
    public static void main(String[] args) {
        Racional r1 = new Racional(2, 4);
        Racional r2 = new Racional(1, 3);
 
        System.out.println("R1: " + r1);
        System.out.println("R2: " + r2);
 
        Racional soma = Racional.adicionar(r1, r2);
        Racional subtracao = Racional.subtrair(r1, r2);
        Racional multiplicacao = Racional.multiplicar(r1, r2);
        Racional divisao = Racional.dividir(r1, r2);
 
        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);
        System.out.println("Divisão: " + divisao);
 
        System.out.println("\nRepresentações decimais:");
        System.out.println("R1 decimal (padrão): " + r1.toDecimal());
        System.out.println("R1 decimal (4 casas): " + r1.toDecimal(4));
        System.out.println("R2 decimal (padrão): " + r2.toDecimal());
        System.out.println("R2 decimal (4 casas): " + r2.toDecimal(4));
    }
 }