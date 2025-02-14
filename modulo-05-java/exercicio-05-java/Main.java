
class Ponto {
    private double x;
    private double y;

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Quadrilatero {
    private Ponto p1, p2, p3, p4;

    public Quadrilatero(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Ponto getP1() {
        return p1;
    }

    public Ponto getP2() {
        return p2;
    }

    public Ponto getP3() {
        return p3;
    }

    public Ponto getP4() {
        return p4;
    }
    public double calcularArea() {
        return 0; 
    }
}
class Trapezio extends Quadrilatero {
    public Trapezio(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    public double calcularArea() {

        double baseMaior = Math.abs(getP2().getX() - getP1().getX());
        double baseMenor = Math.abs(getP4().getX() - getP3().getX());
        double altura = Math.abs(getP1().getY() - getP3().getY());
        return ((baseMaior + baseMenor) * altura) / 2;
    }
}

class Paralelogramo extends Quadrilatero {
    public Paralelogramo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    public double calcularArea() {
        
        double base = Math.abs(getP2().getX() - getP1().getX());
        double altura = Math.abs(getP1().getY() - getP3().getY());
        return base * altura;
    }
}

class Retangulo extends Paralelogramo {
    public Retangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    public double calcularArea() {
        
        double base = Math.abs(getP2().getX() - getP1().getX());
        double altura = Math.abs(getP1().getY() - getP3().getY());
        return base * altura;
    }
}

class Quadrado extends Retangulo {
    public Quadrado(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    public double calcularArea() {
    
        double lado = Math.abs(getP2().getX() - getP1().getX());
        return lado * lado;
    }
}

public class Main {
    public static void main(String[] args) {
        
        Ponto p1 = new Ponto(0, 0);
        Ponto p2 = new Ponto(5, 0);
        Ponto p3 = new Ponto(3, 3);
        Ponto p4 = new Ponto(2, 3);

        
        Trapezio trapezio = new Trapezio(p1, p2, p3, p4);
        Paralelogramo paralelogramo = new Paralelogramo(p1, p2, p3, p4);
        Retangulo retangulo = new Retangulo(p1, p2, p3, p4);
        Quadrado quadrado = new Quadrado(p1, p2, p3, p4);

        
        System.out.println("Área do Trapézio: " + trapezio.calcularArea());
        System.out.println("Área do Paralelogramo: " + paralelogramo.calcularArea());
        System.out.println("Área do Retângulo: " + retangulo.calcularArea());
        System.out.println("Área do Quadrado: " + quadrado.calcularArea());
    }
}