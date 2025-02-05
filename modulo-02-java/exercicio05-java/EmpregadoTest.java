import java.text.DecimalFormat;

public class EmpregadoTest {

    public static class Empregado {

        private String primeiroNome;
        private String sobrenome;
        private double salarioMensal;

        public Empregado(String primeiroNome, String sobrenome, double salarioMensal) {
            this.primeiroNome = primeiroNome;
            this.sobrenome = sobrenome;
            if (salarioMensal > 0) {
                this.salarioMensal = salarioMensal;
            } else {
                this.salarioMensal = 0;
            }
        }

        public void setPrimeiroNome(String primeiroNome) {
            this.primeiroNome = primeiroNome;
        }

        public String getPrimeiroNome() {
            return primeiroNome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public void setSalarioMensal(double salarioMensal) {
            if (salarioMensal > 0) {
                this.salarioMensal = salarioMensal;
            }
        }

        public double getSalarioMensal() {
            return salarioMensal;
        }

        public double calcularSalarioAnual() {
            return salarioMensal * 12;
        }

        public void aplicarAumento() {
            salarioMensal *= 1.10;
        }

        public String formatarSalario(double salario) {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            return df.format(salario);
        }
    }

    public static void main(String[] args) {
        
        Empregado empregado1 = new Empregado("João", "Silva", 1000);
        Empregado empregado2 = new Empregado("Maria", "Oliveira", 2000);

        System.out.println("Salário mensal de " + empregado1.getPrimeiroNome() + " " + empregado1.getSobrenome() + ": " + empregado1.formatarSalario(empregado1.getSalarioMensal()));
        System.out.println("Salário anual de " + empregado1.getPrimeiroNome() + " " + empregado1.getSobrenome() + ": " + empregado1.formatarSalario(empregado1.calcularSalarioAnual()));

        System.out.println("Salário mensal de " + empregado2.getPrimeiroNome() + " " + empregado2.getSobrenome() + ": " + empregado2.formatarSalario(empregado2.getSalarioMensal()));
        System.out.println("Salário anual de " + empregado2.getPrimeiroNome() + " " + empregado2.getSobrenome() + ": " + empregado2.formatarSalario(empregado2.calcularSalarioAnual()));

        empregado1.aplicarAumento();
        empregado2.aplicarAumento();

        System.out.println("\nApós aumento de 10%:");
        System.out.println("Salário mensal de " + empregado1.getPrimeiroNome() + " " + empregado1.getSobrenome() + ": " + empregado1.formatarSalario(empregado1.getSalarioMensal()));
        System.out.println("Salário anual de " + empregado1.getPrimeiroNome() + " " + empregado1.getSobrenome() + ": " + empregado1.formatarSalario(empregado1.calcularSalarioAnual()));

        System.out.println("Salário mensal de " + empregado2.getPrimeiroNome() + " " + empregado2.getSobrenome() + ": " + empregado2.formatarSalario(empregado2.getSalarioMensal()));
        System.out.println("Salário anual de " + empregado2.getPrimeiroNome() + " " + empregado2.getSobrenome() + ": " + empregado2.formatarSalario(empregado2.calcularSalarioAnual()));
    }
}
