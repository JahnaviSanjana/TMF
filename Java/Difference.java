import java.util.Scanner;

 class Difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];

        System.out.println("Enter 20 numbers:");

        for (int i = 0; i < 20; i++) {
            numbers[i] = scanner.nextInt();
        }

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < 20; i++) {
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            } else {
                oddSum += numbers[i];
            }
        }

        int difference = evenSum - oddSum;

        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);
        System.out.println("Difference between sum of even and odd numbers: " + difference);

        scanner.close();
    }
}
