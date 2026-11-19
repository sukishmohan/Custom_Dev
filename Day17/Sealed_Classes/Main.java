public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Car("Toyota");
        vehicle.start();
        System.out.println(((Car) vehicle).brand());
    }
}

sealed abstract class Vehicle permits Car, Bike {
    abstract void start();
}

final class Car extends Vehicle {
    private final String brand;

    Car(String brand) {
        this.brand = brand;
    }

    String brand() {
        return brand;
    }

    @Override
    void start() {
        System.out.println(brand + " car is starting");
    }
}

non-sealed class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("Bike is starting");
    }
}
