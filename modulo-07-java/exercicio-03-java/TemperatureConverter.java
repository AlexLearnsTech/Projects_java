import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
    private JTextField celsiusField, fahrenheitField, kelvinField;
    private JButton convertButton, clearButton;

    public TemperatureConverter() {
        
        setTitle("Conversor de Temperatura");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        
        celsiusField = new JTextField();
        fahrenheitField = new JTextField();
        kelvinField = new JTextField();

        mainPanel.add(new JLabel("Celsius:"));
        mainPanel.add(celsiusField);
        mainPanel.add(new JLabel("Fahrenheit:"));
        mainPanel.add(fahrenheitField);
        mainPanel.add(new JLabel("Kelvin:"));
        mainPanel.add(kelvinField);

        convertButton = new JButton("Converter");
        clearButton = new JButton("Limpar");

        mainPanel.add(convertButton);
        mainPanel.add(clearButton);
        add(mainPanel);
        convertButton.addActionListener(new ConvertButtonListener());
        clearButton.addActionListener(new ClearButtonListener());
        setLocationRelativeTo(null);
    }
    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (!celsiusField.getText().isEmpty()) {
                    double celsius = Double.parseDouble(celsiusField.getText());
                    double fahrenheit = celsiusToFahrenheit(celsius);
                    double kelvin = celsiusToKelvin(celsius);
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                    kelvinField.setText(String.format("%.2f", kelvin));
                } else if (!fahrenheitField.getText().isEmpty()) {
                    double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                    double celsius = fahrenheitToCelsius(fahrenheit);
                    double kelvin = fahrenheitToKelvin(fahrenheit);
                    celsiusField.setText(String.format("%.2f", celsius));
                    kelvinField.setText(String.format("%.2f", kelvin));
                } else if (!kelvinField.getText().isEmpty()) {
                    double kelvin = Double.parseDouble(kelvinField.getText());
                    double celsius = kelvinToCelsius(kelvin);
                    double fahrenheit = kelvinToFahrenheit(kelvin);
                    celsiusField.setText(String.format("%.2f", celsius));
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Insira um número válido.");
            }
        }
    }
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            celsiusField.setText("");
            fahrenheitField.setText("");
            kelvinField.setText("");
        }
    }
    private double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5.0) * celsius + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9.0) * (fahrenheit - 32);
    }

    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    private double fahrenheitToKelvin(double fahrenheit) {
        double celsius = fahrenheitToCelsius(fahrenheit);
        return celsiusToKelvin(celsius);
    }

    private double kelvinToFahrenheit(double kelvin) {
        double celsius = kelvinToCelsius(kelvin);
        return celsiusToFahrenheit(celsius);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureConverter converter = new TemperatureConverter();
            converter.setVisible(true);
        });
    }
}