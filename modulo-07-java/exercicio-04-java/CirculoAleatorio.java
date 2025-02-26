import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;

public class CirculoAleatorio extends JFrame {
    class PainelCirculo extends JPanel {
        private double raio;

        public PainelCirculo(double raio) {
            this.raio = raio;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Desenho do círculo
            int diametro = (int) (2 * raio);
            int x = (getWidth() - diametro) / 2;
            int y = (getHeight() - diametro) / 2;
            g.setColor(Color.GREEN);
            g.fillOval(x, y, diametro, diametro);
        }
    }

    private JTextArea resultadoArea;

    public CirculoAleatorio() {
        super("Cálculo e Desenho de Círculo Aleatório");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Gerar raio aleatório
        Random rand = new Random();
        double raio = 45 + rand.nextDouble() * 80; 

        PainelCirculo painelCirculo = new PainelCirculo(raio);

        double diametro = 2 * raio;
        double area = Math.PI * Math.pow(raio, 2);
        double circunferencia = 2 * Math.PI * raio;

        DecimalFormat df = new DecimalFormat("0.00");

        resultadoArea = new JTextArea(5, 20);
        resultadoArea.setEditable(false);
        resultadoArea.setText("Raio: " + df.format(raio) + "\n" +
                             "Diâmetro: " + df.format(diametro) + "\n" +
                             "Área: " + df.format(area) + "\n" +
                             "Circunferência: " + df.format(circunferencia));

        JPanel painelResultado = new JPanel();
        painelResultado.setLayout(new BorderLayout());
        painelResultado.add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(painelCirculo, BorderLayout.CENTER);
        add(painelResultado, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CirculoAleatorio app = new CirculoAleatorio();
                app.setVisible(true);
            }
        });
    }
}
