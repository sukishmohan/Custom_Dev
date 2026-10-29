public class AbstractCircle extends AbstractShape {
    private double radius;

    public AbstractCircle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14 * radius * radius;
    }
}
