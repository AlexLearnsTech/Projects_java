import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.border.EmptyBorder;

public class CalculadoraKmPorLitro extends JFrame {
    
    private JTextField txtKm;
    private JTextField txtLitros;
    private JLabel lblResultado;
    private JButton btnCalcular;
    private JButton btnLimpar;
    
    public CalculadoraKmPorLitro() {
        super("Calculadora de Quilômetros por Litro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null); 
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout(10, 10));
        painelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(2, 2, 10, 10));
        
        painelEntrada.add(new JLabel("Quilômetros percorridos:"));
        txtKm = new JTextField(10);
        painelEntrada.add(txtKm);
        
        painelEntrada.add(new JLabel("Litros consumidos:"));
        txtLitros = new JTextField(10);
        painelEntrada.add(txtLitros);
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularKmPorLitro();
            }
        });
        painelBotoes.add(btnCalcular);
        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        painelBotoes.add(btnLimpar);
        JPanel painelResultado = new JPanel();
        painelResultado.setLayout(new FlowLayout(FlowLayout.CENTER));
        painelResultado.setBorder(new EmptyBorder(20, 0, 0, 0));
        
        lblResultado = new JLabel("Insira os valores e clique em Calcular");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 14));
        painelResultado.add(lblResultado);
        
        painelPrincipal.add(painelEntrada, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);
        painelPrincipal.add(painelResultado, BorderLayout.SOUTH);
        
        add(painelPrincipal);
        getRootPane().setDefaultButton(btnCalcular);
        setVisible(true);
    }
    private void calcularKmPorLitro() {
        try {
            String strKm = txtKm.getText().trim().replace(',', '.');
            String strLitros = txtLitros.getText().trim().replace(',', '.');
            
            if (strKm.isEmpty() || strLitros.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor, preencha todos os campos.", 
                    "Campos vazios", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            double km = Double.parseDouble(strKm);
            double litros = Double.parseDouble(strLitros);
            
            if (km <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "Quilômetros percorridos deve ser maior que zero.", 
                    "Valor inválido", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (litros <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "Litros consumidos deve ser maior que zero.", 
                    "Valor inválido", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            double kmPorLitro = km / litros;
            DecimalFormat df = new DecimalFormat("#,##0.00");
            String resultado = df.format(kmPorLitro);

            lblResultado.setText("Rendimento: " + resultado + " km/l");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, insira valores numéricos válidos.", 
                "Erro de formato", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    private void limparCampos() {
        txtKm.setText("");
        txtLitros.setText("");
        lblResultado.setText("Insira os valores e clique em Calcular");
        txtKm.requestFocus();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraKmPorLitro();
            }
        });
    }
}