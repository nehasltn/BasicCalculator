import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A basic calculator application for performing simple arithmetic operations.
 * Supports addition, subtraction, multiplication, and division.
 * Allows multiple calculations until the user chooses to exit.
 * 
 * Author: Neha Sultana
 * Date: August 4, 2025
 */
public class BasicCalculator {

    // Method to perform addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Method to perform subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method to perform multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method to perform division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        System.out.println("===== Welcome to the Java Console Calculator =====");

        while (continueCalculation) {
            double num1 = 0;
            double num2 = 0;
            char operator;

            try {
                // Input first number
                System.out.print("Enter first number: ");
                num1 = scanner.nextDouble();

                // Input operator
                System.out.print("Enter operator (+, -, *, /): ");
                operator = scanner.next().charAt(0);

                // Input second number
                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();

                // Perform calculation based on operator
                double result;
                switch (operator) {
                    case '+':
                        result = add(num1, num2);
                        break;
                    case '-':
                        result = subtract(num1, num2);
                        break;
                    case '*':
                        result = multiply(num1, num2);
                        break;
                    case '/':
                        result = divide(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid operator. Please use +, -, *, or /.");
                        continue;
                }

                // Display result
                if (!Double.isNaN(result)) {
                    System.out.println("Result: " + result);
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
                scanner.nextLine(); // clear invalid input
                continue;
            }

            // Ask user if they want to continue
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String response = scanner.next().toLowerCase();

            if (!response.equals("yes")) {
                continueCalculation = false;
                System.out.println("Thank you for using the calculator. Goodbye!");
            }
        }

        scanner.close();
    }
}
