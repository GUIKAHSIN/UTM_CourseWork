import java.util.Scanner;

public class BMIScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get user input
        System.out.print("Enter your weight (kg): ");
        double weight = input.nextDouble();

        System.out.print("Enter your height (m): ");
        double height = input.nextDouble();

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
        System.out.println("Your BMI is: " + String.format("%.2f", bmi) + " (" + category + ")");

        input.close();
    }
}
