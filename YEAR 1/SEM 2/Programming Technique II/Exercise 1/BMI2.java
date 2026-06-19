import javax.swing.JOptionPane;

public class BMI2{
    public static void main(String[] args) {
        // Get input as String
        String q1= JOptionPane.showInputDialog("Enter your weight (kg):");
        String q2= JOptionPane.showInputDialog("Enter your height (m):");

        // Convert input to double
        double weight = Double.parseDouble(q1);
        double height = Double.parseDouble(q2);

        // Calculate BMI
        double bmi = weight / (height * height);

        // Display result
        JOptionPane.showMessageDialog(null, "Your BMI is: " + bmi);
    }
}

