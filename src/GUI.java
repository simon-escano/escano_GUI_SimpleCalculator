import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JPanel jpanel;
    private JPanel inputBox;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JLabel lblResult;
    private JButton btnCompute;

    public GUI() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1, num2;
                try {
                    num1 = Integer.parseInt(tfNumber1.getText());
                    num2 = Integer.parseInt(tfNumber2.getText());
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "Both inputs must be a valid number.");
                    return;
                }
                String op = (String) cbOperations.getSelectedItem();
                switch (op) {
                    case "+":
                        lblResult.setText(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        lblResult.setText(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        lblResult.setText(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        try {
                            lblResult.setText(String.valueOf(num1 / num2));
                        } catch (ArithmeticException a) {
                            lblResult.setText("Error");
                        }
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        GUI app = new GUI();
        app.setContentPane(app.jpanel);
        app.setSize(400, 200);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("Simple Calculator");
        app.setVisible(true);
    }
}
