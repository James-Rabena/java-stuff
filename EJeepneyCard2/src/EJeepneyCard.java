public class EJeepneyCard {
    private static int cardCounter = 1;
    private String cardNumber;
    private String name;
    private double balance;

    public EJeepneyCard(String name) {
        this.name = name;
        this.cardNumber = "QCJEEP" + cardCounter++;
        this.balance = 0.0;
    }

    public void loadMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Loaded Php %.2f. New balance: Php %.2f.%n", amount, balance);
        } else {
            System.out.println("Invalid amount to load.");
        }
    }

    public boolean tap(double fare) {
        if (balance >= fare) {
            balance -= fare;
            System.out.printf("Fare Php %.2f deducted. Remaining balance: Php %.2f.%n", fare, balance);
            return true;
        } else {
            System.out.println("Insufficient balance!");
            return false;
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}