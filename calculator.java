import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculatorGUI extends JFrame implements ActionListener {
    private JTextField numField1, numField2, resultField;
    private JComboBox<String> operatorComboBox;
    private JButton calculateButton;

    public SimpleCalculatorGUI() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel numLabel1 = new JLabel("First number:");
        numLabel1.setBounds(10, 20, 80, 25);
        panel.add(numLabel1);

        numField1 = new JTextField(10);
        numField1.setBounds(100, 20, 165, 25);
        panel.add(numField1);

        JLabel operatorLabel = new JLabel("Operator:");
        operatorLabel.setBounds(10, 50, 80, 25);
        panel.add(operatorLabel);

        String[] operators = {"+", "-", "*", "/"};
        operatorComboBox = new JComboBox<>(operators);
        operatorComboBox.setBounds(100, 50, 80, 25);
        panel.add(operatorComboBox);

        JLabel numLabel2 = new JLabel("Second number:");
        numLabel2.setBounds(10, 80, 120, 25);
        panel.add(numLabel2);

        numField2 = new JTextField(10);
        numField2.setBounds(130, 80, 165, 25);
        panel.add(numField2);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(100, 120, 100, 25);
        calculateButton.addActionListener(this);
        panel.add(calculateButton);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(10, 150, 80, 25);
        panel.add(resultLabel);

        resultField = new JTextField(10);
        resultField.setEditable(false);
        resultField.setBounds(100, 150, 165, 25);
        panel.add(resultField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            char operator = operatorComboBox.getSelectedItem().toString().charAt(0);
            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    resultField.setText(Double.toString(result));
                    break;
                case '-':
                    result = num1 - num2;
                    resultField.setText(Double.toString(result));
                    break;
                case '*':
                    result = num1 * num2;
                    resultField.setText(Double.toString(result));
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        resultField.setText(Double.toString(result));
                    } else {
                        resultField.setText("Error: Division by zero");
                    }
                    break;
                default:
                    resultField.setText("Invalid operator");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculatorGUI calculator = new SimpleCalculatorGUI();
            calculator.setVisible(true);
        });
    }
}

