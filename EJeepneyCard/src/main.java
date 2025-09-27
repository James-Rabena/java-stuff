public class Main {
    public static void main(String[] args) {
        EJeepneyCard card = new EJeepneyCard("James Rabena");

        System.out.println("Card Number: " + card.getCardNumber());
        System.out.println("Card Holder: " + card.getCardHolderName());

        card.loadMoney(100);
        card.tap(15);
        card.tap(90);
        System.out.println("Final Balance: Php " + card.getBalance());
    }
}
