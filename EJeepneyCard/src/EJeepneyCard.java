public class EJeepneyCard {
    // Private attributes (data abstraction)
    private String cardNumber;
    private double balance;
    private String cardHolderName;

    // Static counter to ensure unique card numbers
    private static int cardCounter = 1;

    // Constructor - Creates a new card
    public EJeepneyCard(String name) {
        this.cardHolderName = name;
        this.balance = 0.0;
        this.cardNumber = "QCJEEP" + cardCounter++;
    }

    // Method to load money to the card
    public void loadMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Loaded Php " + amount + ". New balance: Php " + balance);
        } else {
            System.out.println("Invalid amount. Load must be greater than 0.");
        }
    }

    // Method to tap for a ride
    public boolean tap(double fare) {
        if (balance >= fare) {
            balance -= fare;
            System.out.println("Fare Php " + fare + " deducted. Remaining balance: Php " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance!");
            return false;
        }
    }

    // Method to get the card number
    public String getCardNumber() {
        return cardNumber;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Optional: Method to get cardholder name
    public String getCardHolderName() {
        return cardHolderName;
    }
}
