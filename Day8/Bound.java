class Calculator<T extends Number> {

    T number;

    Calculator(T number) {
        this.number = number;
    }

    double square() {
        return number.doubleValue() * number.doubleValue();
    }
}

public class Bound {
    public static void main(String[] args) {

        Calculator<Integer> c1 = new Calculator<>(10);
        Calculator<Double> c2 = new Calculator<>(5.5);

        System.out.println(c1.square());
        System.out.println(c2.square());
    }
}