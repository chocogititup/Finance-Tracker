import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceTracker tracker = new FinanceTracker();
        FileHandler.loadFromFile(tracker);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Personal Finance Tracker ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Summary");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Type (Income/Expense): ");
                    String type = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    Transaction t = new Transaction(date, type, category, amount);
                    tracker.addTransaction(t);
                    FileHandler.saveToFile(tracker.getTransactions());
                }
                case 2 -> {
                    System.out.println("--- Transactions ---");
                    for (Transaction t : tracker.getTransactions()) {
                        System.out.println(t);
                    }
                }
                case 3 -> {
                    System.out.println("Total Income: $" + tracker.getTotalIncome());
                    System.out.println("Total Expenses: $" + tracker.getTotalExpenses());
                }
                case 4 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
