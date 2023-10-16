import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];

        System.out.println("Enter 20 numbers:");

        for (int i = 0; i < 20; i++) {
            numbers[i] = scanner.nextInt();
        }

        int[] evenNumbers = new int[20];
        int[] oddNumbers = new int[20];
        int[] primeNumbers = new int[20];

        int evenIndex = 0, oddIndex = 0,primeIndex = 0;

        for (int i = 0; i < 20; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers[evenIndex++] = numbers[i];
            } else {
                oddNumbers[oddIndex++] = numbers[i];
            }

            int j;

            if (numbers[i] <= 1) {
                // Skip 0, 1 as prime
            } else {
                for (j = 2; j * j <= numbers[i]; j++) {
                    if (numbers[i] % j == 0) {
                        break;
                    }
                }
                if (j * j > numbers[i]) {
                    primeNumbers[primeIndex++] = numbers[i];
                }
            }
        }

        System.out.println("Even numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

        System.out.println("\nOdd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        System.out.println("\nPrime numbers:");
        for (int i = 0; i < primeIndex; i++) {
            System.out.print(primeNumbers[i] + " ");
        }
    }
}
