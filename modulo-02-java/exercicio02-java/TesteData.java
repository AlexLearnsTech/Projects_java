public class TesteData {

    public static class Data {
        
        private int mes;
        private int dia;
        private int ano;

        public Data(int mes, int dia, int ano) {
            this.mes = mes;
            this.dia = dia;
            this.ano = ano;
        }
        public void setMes(int mes) {
            this.mes = mes;
        }
        public int getMes() {
            return mes;
        }
        public void setDia(int dia) {
            this.dia = dia;
        }
        public int getDia() {
            return dia;
        }
        public void setAno(int ano) {
            this.ano = ano;
        }
        public int getAno() {
            return ano;
        }
        public void showDate() {
            System.out.println(mes + "/" + dia + "/" + ano);
        }
    }
    public static void main(String[] args) {
        
        Data data1 = new Data(1, 25, 2025);

        System.out.print("Data inicial: ");
        data1.showDate();

        data1.setMes(12);
        data1.setDia(31);
        data1.setAno(2025);

        System.out.print("Data modificada: ");
        data1.showDate();
    }
}
