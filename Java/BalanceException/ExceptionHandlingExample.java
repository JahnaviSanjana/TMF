public class ExceptionHandlingExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        try {
            account.withdraw(1500.0);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}