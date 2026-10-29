public abstract class AbstractShape {
    public abstract double area();

    public void printArea() {
        System.out.println("Area: " + area());
    }

    public void printArea(String shapeName) {
        System.out.println(shapeName + " area: " + area());
    }
}
