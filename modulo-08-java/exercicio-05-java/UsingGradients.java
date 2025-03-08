import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsingGradients extends JFrame {
    private JPanel gradientPanel;
    private JRadioButton linearGradientButton, radialGradientButton;
    private JTextField startRedField, startGreenField, startBlueField, startAlphaField;
    private JTextField endRedField, endGreenField, endBlueField, endAlphaField;

    public UsingGradients() {
        setTitle("UsingGradients");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                Color startColor = getColorFromFields(startRedField, startGreenField, startBlueField, startAlphaField);
                Color endColor = getColorFromFields(endRedField, endGreenField, endBlueField, endAlphaField);

                if (linearGradientButton.isSelected()) {
                    GradientPaint gradient = new GradientPaint(
                            0, 0, startColor,
                            getWidth(), getHeight(), endColor
                    );
                    g2d.setPaint(gradient);
                } else {
                    RadialGradientPaint gradient = new RadialGradientPaint(
                            new Point(getWidth() / 2, getHeight() / 2), 
                            Math.min(getWidth(), getHeight()) / 2, 
                            new float[]{0.0f, 1.0f},
                            new Color[]{startColor, endColor}
                    );
                    g2d.setPaint(gradient);
                }
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        JPanel controlPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        linearGradientButton = new JRadioButton("Gradiente Linear", true);
        radialGradientButton = new JRadioButton("Gradiente Radial");
        ButtonGroup gradientGroup = new ButtonGroup();
        gradientGroup.add(linearGradientButton);
        gradientGroup.add(radialGradientButton);

        startRedField = new JTextField("255", 3);
        startGreenField = new JTextField("0", 3);
        startBlueField = new JTextField("0", 3);
        startAlphaField = new JTextField("255", 3);

        endRedField = new JTextField("0", 3);
        endGreenField = new JTextField("0", 3);
        endBlueField = new JTextField("255", 3);
        endAlphaField = new JTextField("255", 3);

        JButton applyButton = new JButton("Aplicar Gradiente");
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gradientPanel.repaint(); 
            }
        });

        controlPanel.add(new JLabel("Tipo de Gradiente:"));
        controlPanel.add(linearGradientButton);
        controlPanel.add(new JLabel(""));
        controlPanel.add(radialGradientButton);

        controlPanel.add(new JLabel("Cor Inicial (RGBA):"));
        controlPanel.add(createColorInputPanel(startRedField, startGreenField, startBlueField, startAlphaField));

        controlPanel.add(new JLabel("Cor Final (RGBA):"));
        controlPanel.add(createColorInputPanel(endRedField, endGreenField, endBlueField, endAlphaField));

        controlPanel.add(new JLabel(""));
        controlPanel.add(applyButton);
        add(gradientPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }
    private JPanel createColorInputPanel(JTextField redField, JTextField greenField, JTextField blueField, JTextField alphaField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.add(new JLabel("R:"));
        panel.add(redField);
        panel.add(new JLabel("G:"));
        panel.add(greenField);
        panel.add(new JLabel("B:"));
        panel.add(blueField);
        panel.add(new JLabel("A:"));
        panel.add(alphaField);
        return panel;
    }
    private Color getColorFromFields(JTextField redField, JTextField greenField, JTextField blueField, JTextField alphaField) {
        int r = Integer.parseInt(redField.getText());
        int g = Integer.parseInt(greenField.getText());
        int b = Integer.parseInt(blueField.getText());
        int a = Integer.parseInt(alphaField.getText());
        return new Color(r, g, b, a);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UsingGradients app = new UsingGradients();
            app.setVisible(true);
        });
    }
}