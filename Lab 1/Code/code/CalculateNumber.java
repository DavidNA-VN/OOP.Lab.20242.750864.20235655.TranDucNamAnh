import javax.swing.JOptionPane;

public class CalculateNumber {
    public static void main(String[] args) {
        try {
            String input1 = JOptionPane.showInputDialog(null,
                    "Please input the first number:", 
                    "Input the first number", 
                    JOptionPane.INFORMATION_MESSAGE);
            String input2 = JOptionPane.showInputDialog(null,
                    "Please input the second number:", 
                    "Input the second number", 
                    JOptionPane.INFORMATION_MESSAGE);

            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);

            double sum = num1 + num2;
            double difference = num1 - num2;
            double product = num1 * num2;
            String result = "Sum: " + sum + "\n" +
                            "Difference: " + difference + "\n" +
                            "Product: " + product + "\n";

            if (num2 != 0) {
                double quotient = num1 / num2;
                result += "Quotient: " + quotient;
            } else {
                result += "Division by 0 is not allowed!";
            }

            JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                    "Invalid input! Please enter a number.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
