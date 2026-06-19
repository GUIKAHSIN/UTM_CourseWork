import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter your weight (kg): ");
        double weight = input.nextDouble();
        
        System.out.print("Enter your height (m): ");
        double height = input.nextDouble();
        
        // Calculate BMI
        double bmi = weight / (height * height);
        
        // Display result
        System.out.print("Your BMI is: " + bmi);
        
        input.close();
    }
}

