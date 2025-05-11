public class Transaction {
    private String date;
    private String type; // "Income" or "Expense"
    private String category;
    private double amount;

    public Transaction(String date, String type, String category, double amount) {
        this.date = date;
        this.type = type;
        this.category = category;
        this.amount = amount;
    }

    public String toCSV() {
        return date + "," + type + "," + category + "," + amount;
    }

    public static Transaction fromCSV(String line) {
        String[] parts = line.split(",");
        return new Transaction(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }

    @Override
    public String toString() {
        return date + " | " + type + " | " + category + " | $" + amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
