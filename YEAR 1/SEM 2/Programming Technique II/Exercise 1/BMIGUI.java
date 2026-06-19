import javax.swing.JOptionPane;

public class BMIGUI {
    public static void main(String[] args) {
        try {
            // Get input as String
            String q1 = JOptionPane.showInputDialog("Enter your weight (kg):");
            String q2 = JOptionPane.showInputDialog("Enter your height (m):");

            // Convert input to double
            double weight = Double.parseDouble(q1);
            double height = Double.parseDouble(q2);

            // Calculate BMI
            double bmi = weight / (height * height);

            // Determine BMI category
            String category;
            if (bmi < 18.5) {
                category = "Underweight";
            } else if (bmi < 25) {
                category = "Normal";
            } else if (bmi < 30) {
                category = "Overweight";
            } else {
                category = "Obese";
            }

            // Display result
            JOptionPane.showMessageDialog(null, "Your BMI is: " + String.format("%.2f", bmi) + " (" + category + ")");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter numeric values only.");
        }
    }
}
