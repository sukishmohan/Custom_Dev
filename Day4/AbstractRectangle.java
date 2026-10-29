public class AbstractRectangle extends AbstractShape {
    private double length;
    private double width;

    public AbstractRectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}
