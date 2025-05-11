import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private static final String FILE_NAME = "transactions.csv";

    public static void saveToFile(List<Transaction> transactions) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Transaction t : transactions) {
                pw.println(t.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static void loadFromFile(FinanceTracker tracker) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Transaction t = Transaction.fromCSV(line);
                tracker.addTransaction(t);
            }
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
