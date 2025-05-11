import java.util.ArrayList;
import java.util.List;

public class FinanceTracker {
    private List<Transaction> transactions;

    public FinanceTracker() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getTotalIncome() {
        return transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Income"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getTotalExpenses() {
        return transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
