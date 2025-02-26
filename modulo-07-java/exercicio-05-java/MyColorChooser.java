import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MyColorChooser extends JPanel {
    private JSlider redSlider, greenSlider, blueSlider;
    private JTextField redTextField, greenTextField, blueTextField;
    private JPanel colorDisplayPanel;
    private Color currentColor;

    public MyColorChooser() {
        // Configura o layout do painel principal como BorderLayout
        setLayout(new BorderLayout(10, 10));

        // Painel para os sliders e text fields
        JPanel controlPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10)); // Espaçamento interno

        // Inicializa os sliders e text fields
        redSlider = createSlider(0, 255, 0);
        greenSlider = createSlider(0, 255, 0);
        blueSlider = createSlider(0, 255, 0);

        redTextField = createTextField();
        greenTextField = createTextField();
        blueTextField = createTextField();

        // Adiciona os componentes ao painel de controle
        controlPanel.add(new JLabel("Red:"));
        controlPanel.add(redSlider);
        controlPanel.add(redTextField);
        controlPanel.add(new JLabel("Green:"));
        controlPanel.add(greenSlider);
        controlPanel.add(greenTextField);
        controlPanel.add(new JLabel("Blue:"));
        controlPanel.add(blueSlider);
        controlPanel.add(blueTextField);

        // Painel para exibir a cor atual
        colorDisplayPanel = new JPanel();
        colorDisplayPanel.setPreferredSize(new Dimension(100, 100));
        currentColor = new Color(0, 0, 0); // Cor inicial preta
        colorDisplayPanel.setBackground(currentColor);

        // Adiciona os painéis ao painel principal
        add(controlPanel, BorderLayout.CENTER);
        add(colorDisplayPanel, BorderLayout.SOUTH);

        // Atualiza a cor e os text fields quando os sliders são alterados
        redSlider.addChangeListener(new SliderChangeListener());
        greenSlider.addChangeListener(new SliderChangeListener());
        blueSlider.addChangeListener(new SliderChangeListener());
    }

    // Cria um JSlider com configurações padrão
    private JSlider createSlider(int min, int max, int initialValue) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, initialValue);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        return slider;
    }

    // Cria um JTextField com configurações padrão
    private JTextField createTextField() {
        JTextField textField = new JTextField(5);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.CENTER);
        return textField;
    }

    // Atualiza a cor e os text fields com base nos valores dos sliders
    private void updateColor() {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();

        currentColor = new Color(red, green, blue);
        colorDisplayPanel.setBackground(currentColor);

        redTextField.setText(String.valueOf(red));
        greenTextField.setText(String.valueOf(green));
        blueTextField.setText(String.valueOf(blue));
    }

    // Listener para detectar mudanças nos sliders
    private class SliderChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            updateColor();
        }
    }

    public static void main(String[] args) {
        // Cria a janela principal
        JFrame frame = new JFrame("Color Chooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Adiciona o MyColorChooser à janela
        MyColorChooser colorChooser = new MyColorChooser();
        frame.add(colorChooser);

        // Centraliza a janela e a torna visível
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}