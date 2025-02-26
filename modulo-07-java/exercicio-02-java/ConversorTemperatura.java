import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ConversorTemperatura extends JFrame {
    private JTextField fahrenheitField;
    private JLabel celsiusLabel;
    private JButton convertButton;
    private DecimalFormat df = new DecimalFormat("0.00");
    
    public ConversorTemperatura() {
        super("Conversor de Temperatura");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        
        JPanel formulaPanel = new JPanel(new BorderLayout());
        formulaPanel.setBackground(new Color(255, 255, 230));
        formulaPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        
        JLabel formulaLabel = new JLabel("<html><div style='text-align: center;'>Celsius = <sup>5</sup>&frasl;<sub>9</sub> × (Fahrenheit - 32)</div></html>", JLabel.CENTER);
        formulaLabel.setFont(new Font("Serif", Font.BOLD, 18));
        formulaPanel.add(formulaLabel, BorderLayout.CENTER);
        
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        
        JLabel fahrenheitLabel = new JLabel("Temperatura Fahrenheit:", JLabel.RIGHT);
        fahrenheitField = new JTextField(10);
        fahrenheitField.setHorizontalAlignment(JTextField.RIGHT);
        
        JLabel resultLabel = new JLabel("Temperatura Celsius:", JLabel.RIGHT);
        celsiusLabel = new JLabel("0.00 °C");
        celsiusLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        celsiusLabel.setHorizontalAlignment(JLabel.RIGHT);
        celsiusLabel.setBackground(Color.WHITE);
        celsiusLabel.setOpaque(true);
        
        inputPanel.add(fahrenheitLabel);
        
        JPanel fieldButtonPanel = new JPanel(new BorderLayout(5, 0));
        fieldButtonPanel.add(fahrenheitField, BorderLayout.CENTER);
        
        convertButton = new JButton("Converter");
        fieldButtonPanel.add(convertButton, BorderLayout.EAST);
        
        inputPanel.add(fieldButtonPanel);
        inputPanel.add(resultLabel);
        inputPanel.add(celsiusLabel);
    
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                converterTemperatura();
            }
        });
        
        fahrenheitField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                converterTemperatura();
            }
        });
        
        mainPanel.add(formulaPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        setContentPane(mainPanel);
    }
    
    private void converterTemperatura() {
        try {
            double fahrenheit = Double.parseDouble(fahrenheitField.getText().trim());
            double celsius = (5.0 / 9.0) * (fahrenheit - 32);
            celsiusLabel.setText(df.format(celsius) + " °C");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido.", 
                "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            fahrenheitField.requestFocus();
            fahrenheitField.selectAll();
        }
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ConversorTemperatura app = new ConversorTemperatura();
                app.setVisible(true);
                app.fahrenheitField.requestFocus();
            }
        });
    }
}
