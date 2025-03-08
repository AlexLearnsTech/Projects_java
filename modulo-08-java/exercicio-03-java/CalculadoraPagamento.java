import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraPagamento extends JFrame {

    private JTextField txtValor1;
    private JTextField txtValor2; 
    private JLabel lblResultado; 

    public CalculadoraPagamento() {
        super("Calculadora de Pagamento");

        setLayout(new FlowLayout());

        JLabel lblValor1 = new JLabel("Insira o primeiro valor:");
        txtValor1 = new JTextField(10);

        JLabel lblValor2 = new JLabel("Insira o segundo valor:");
        txtValor2 = new JTextField(10);

        JButton btnCalcular = new JButton("Calcular");
        lblResultado = new JLabel("Resultado: ");

        add(lblValor1);
        add(txtValor1);
        add(lblValor2);
        add(txtValor2);
        add(btnCalcular);
        add(lblResultado);
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor1 = Integer.parseInt(txtValor1.getText());
                    int valor2 = Integer.parseInt(txtValor2.getText());
                    int resultado = valor1 + valor2;
                    lblResultado.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Por favor, digite valores numéricos válidos.");
                }
            }
        });
        setSize(300, 150);                  
        setLocationRelativeTo(null);            
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);                 
    }

    public static void main(String[] args) {
        new CalculadoraPagamento();
    }
}
