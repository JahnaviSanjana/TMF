import java.util.Scanner;

class ExceptionHandlingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter a number: ");
            int num = Integer.parseInt(scanner.nextLine());

            int result = 10 / num;

            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            System.out.println("Program execution completed.");
        }
    }
}
