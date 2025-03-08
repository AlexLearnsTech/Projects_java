import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class PolilinhaApp extends JFrame {
    private final LinkedList<Point> pontos = new LinkedList<>();
    private Point cursorAtual = new Point();

    public PolilinhaApp() {
        setTitle("Aplicativo Polilinha");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                if (pontos.size() > 1) {
                    g2d.setColor(Color.BLACK);
                    Point anterior = pontos.getFirst();
                    for (Point p : pontos) {
                        g2d.drawLine(anterior.x, anterior.y, p.x, p.y);
                        anterior = p;
                    }
                }
                g2d.setColor(Color.RED);
                int raio = 5;
                g2d.fillOval(cursorAtual.x - raio, cursorAtual.y - raio, 2 * raio, 2 * raio);
            }
        };

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                
                cursorAtual = e.getPoint();
                pontos.addFirst(new Point(cursorAtual));
                
                if (pontos.size() > 50) {
                    pontos.removeLast();
                }
                
                panel.repaint();
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PolilinhaApp().setVisible(true));
    }
}