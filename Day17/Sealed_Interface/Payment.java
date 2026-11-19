public sealed interface Payment permits Card, Cash, UPI {
    void pay(double amount);
}
