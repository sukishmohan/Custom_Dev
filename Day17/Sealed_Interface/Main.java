public class Main {
    public static void main(String[] args) {
        Payment cardPayment = new Card();
        Payment cashPayment = new Cash();
        Payment upiPayment = new UPI();

        cardPayment.pay(1500);
        cashPayment.pay(500);
        upiPayment.pay(750);
    }
}
