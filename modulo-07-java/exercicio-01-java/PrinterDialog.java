import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrinterDialog extends JFrame {

    public PrinterDialog() {
        setTitle("Printer");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel printerNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel printerLabel = new JLabel("Printer: MyPrinter");
        printerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        printerNamePanel.add(printerLabel);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 0));

        JPanel leftOptionsPanel = new JPanel(new GridLayout(3, 1));
        JCheckBox imageCheckbox = new JCheckBox("Image");
        imageCheckbox.setSelected(true);
        JCheckBox textCheckbox = new JCheckBox("Text");
        JCheckBox codeCheckbox = new JCheckBox("Code");
        leftOptionsPanel.add(imageCheckbox);
        leftOptionsPanel.add(textCheckbox);
        leftOptionsPanel.add(codeCheckbox);

        JPanel rightOptionsPanel = new JPanel(new GridLayout(3, 1));
        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton selectionRadio = new JRadioButton("Selection");
        JRadioButton allRadio = new JRadioButton("All");
        allRadio.setSelected(true);
        JRadioButton appletRadio = new JRadioButton("Applet");

        radioGroup.add(selectionRadio);
        radioGroup.add(allRadio);
        radioGroup.add(appletRadio);
        rightOptionsPanel.add(selectionRadio);
        rightOptionsPanel.add(allRadio);
        rightOptionsPanel.add(appletRadio);

        centerPanel.add(leftOptionsPanel);
        centerPanel.add(rightOptionsPanel);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel qualityLabel = new JLabel("Print Quality:");
        String[] qualities = {"High", "Medium", "Low"};
        JComboBox<String> qualityComboBox = new JComboBox<>(qualities);
        JCheckBox printToFileCheckbox = new JCheckBox("Print to File");

        bottomPanel.add(qualityLabel);
        bottomPanel.add(qualityComboBox);
        bottomPanel.add(Box.createHorizontalStrut(20));
        bottomPanel.add(printToFileCheckbox);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 10));
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        JButton setupButton = new JButton("Setup...");
        JButton helpButton = new JButton("Help");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("OK button clicked");
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel button clicked");
            }
        });
        setupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Setup button clicked");
            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Help button clicked");
            }
        });

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(setupButton);
        buttonPanel.add(helpButton);

        mainPanel.add(printerNamePanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(buttonPanel, BorderLayout.EAST);

        add(mainPanel);
        setLocationRelativeTo(null);
    } 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PrinterDialog dialog = new PrinterDialog();
                dialog.setVisible(true);
            }
        });
    }
}
