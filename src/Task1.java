
    import java.util.Scanner;

    public class Task1{

        // Method for addition
        public static double add(double a, double b) {
            return a + b;
        }

        // Method for subtraction
        public static double subtract(double a, double b) {
            return a - b;
        }

        // Method for multiplication
        public static double multiply(double a, double b) {
            return a * b;
        }

        // Method for division
        public static double divide(double a, double b) {
            if (b == 0) {
                System.out.println("Error: Cannot divide by zero.");
                return Double.NaN;
            }
            return a / b;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean keepRunning = true;

            while (keepRunning) {
                // Display menu
                System.out.println("\n=== Simple Calculator ===");
                System.out.println("Choose an operation:");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("5. Exit");
                System.out.print("Enter choice (1-5): ");

                int choice = scanner.nextInt();

                if (choice == 5) {
                    keepRunning = false;
                    System.out.println("Exiting calculator. Goodbye!");
                    break;
                }

                // Get numbers from user
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                // Perform operation
                double result;
                switch (choice) {
                    case 1:
                        result = add(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 2:
                        result = subtract(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 3:
                        result = multiply(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 4:
                        result = divide(num1, num2);
                        if (!Double.isNaN(result)) {
                            System.out.println("Result: " + result);
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1 to 5.");
                }
            }
            scanner.close();
        }
    }
