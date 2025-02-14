
class EmpregadoComissao {
    private final String primeiroNome;
    private final String sobrenomePaterno;
    private final String numeroCPF;
    private double vendasBrutas;
    private double porcentagemComissao;

    public EmpregadoComissao(String primeiroNome, String sobrenomePaterno, 
            String numeroCPF, double vendasBrutas, double porcentagemComissao) {
        
        if (vendasBrutas < 0.0) {
            throw new IllegalArgumentException("Vendas brutas devem ser >= 0.0");
        }
        
        if (porcentagemComissao <= 0.0 || porcentagemComissao >= 1.0) {
            throw new IllegalArgumentException(
                "Porcentagem comissão deve ser > 0.0 e < 1.0");
        }
        
        this.primeiroNome = primeiroNome;
        this.sobrenomePaterno = sobrenomePaterno;
        this.numeroCPF = numeroCPF;
        this.vendasBrutas = vendasBrutas;
        this.porcentagemComissao = porcentagemComissao;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getSobrenomePaterno() {
        return sobrenomePaterno;
    }

    public String getNumeroCPF() {
        return numeroCPF;
    }

    public void setVendasBrutas(double vendasBrutas) {
        if (vendasBrutas < 0.0) {
            throw new IllegalArgumentException("Vendas brutas devem ser >= 0.0");
        }
        
        this.vendasBrutas = vendasBrutas;
    }

    public double getVendasBrutas() {
        return vendasBrutas;
    }

    public void setPorcentagemComissao(double porcentagemComissao) {
        if (porcentagemComissao <= 0.0 || porcentagemComissao >= 1.0) {
            throw new IllegalArgumentException(
                "Porcentagem comissão deve ser > 0.0 e < 1.0");
        }
        
        this.porcentagemComissao = porcentagemComissao;
    }

    public double getPorcentagemComissao() {
        return porcentagemComissao;
    }

    public double entradas() {
        return porcentagemComissao * vendasBrutas;
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", 
            "empregado comissionado", primeiroNome, sobrenomePaterno, 
            "número do CPF", numeroCPF, 
            "vendas brutas", vendasBrutas, 
            "porcentagem de comissão", porcentagemComissao);
    }
}
class EmpregadoBaseMaisComissao {
    private final EmpregadoComissao empregadoComissao; 
    private double salarioBase; 
    
    public EmpregadoBaseMaisComissao(String primeiroNome, String sobrenomePaterno,
            String numeroCPF, double vendasBrutas, double porcentagemComissao, 
            double salarioBase) {
        
        empregadoComissao = new EmpregadoComissao(primeiroNome, sobrenomePaterno,
                numeroCPF, vendasBrutas, porcentagemComissao);
        
        if (salarioBase < 0.0) {
            throw new IllegalArgumentException("O salário base deve ser >= 0.0");
        }
        
        this.salarioBase = salarioBase;
    }
    
    public void setSalarioBase(double salarioBase) {
        if (salarioBase < 0.0) {
            throw new IllegalArgumentException("O salário base deve ser >= 0.0");
        }
        
        this.salarioBase = salarioBase;
    }
    
    public double getSalarioBase() {
        return salarioBase;
    }
    
    public double entradas() {
        return getSalarioBase() + empregadoComissao.entradas();
    }
    
    public String getPrimeiroNome() {
        return empregadoComissao.getPrimeiroNome();
    }
    
    public String getSobrenomePaterno() {
        return empregadoComissao.getSobrenomePaterno();
    }
    
    public String getNumeroCPF() {
        return empregadoComissao.getNumeroCPF();
    }
    
    public void setVendasBrutas(double vendasBrutas) {
        empregadoComissao.setVendasBrutas(vendasBrutas);
    }
    
    public double getVendasBrutas() {
        return empregadoComissao.getVendasBrutas();
    }
    
    public void setPorcentagemComissao(double porcentagemComissao) {
        empregadoComissao.setPorcentagemComissao(porcentagemComissao);
    }
    
    public double getPorcentagemComissao() {
        return empregadoComissao.getPorcentagemComissao();
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s%n%s: %.2f", 
            "empregado assalariado com comissão", empregadoComissao.toString(),
            "salário base", getSalarioBase());
    }
}

public class EmpregadoComissionadoCompleto {
    public static void main(String[] args) {
        
        EmpregadoBaseMaisComissao empregado = 
            new EmpregadoBaseMaisComissao(
                "Alex", "Magalhães", "111.222.333-44", 10000, .05, 1000);
        
        System.out.println("Informações do empregado obtidas por métodos get:");
        System.out.printf("%n%s %s%n", "Seu primeiro nome é :",
            empregado.getPrimeiroNome());
        System.out.printf("%s %s%n", "Seu sobrenome é :", 
            empregado.getSobrenomePaterno());
        System.out.printf("%s %s%n", "CPF é :", 
            empregado.getNumeroCPF());
        System.out.printf("%s %.2f%n", "Vendas brutas são :", 
            empregado.getVendasBrutas());
        System.out.printf("%s %.2f%n", "Porcentagem comissão é",
            empregado.getPorcentagemComissao());
        System.out.printf("%s %.2f%n", "Salário base é :",
            empregado.getSalarioBase());
        
        empregado.setSalarioBase(1000);
        
        System.out.printf("%n%s:%n%n%s%n", 
            "Informações atualizadas do empregado obtidas por toString",
            empregado.toString());
    }
}