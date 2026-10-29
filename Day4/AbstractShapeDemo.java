public class AbstractShapeDemo {
    public static void main(String[] args) {
        AbstractShape circle = new AbstractCircle(2);
        AbstractShape rectangle = new AbstractRectangle(4, 5);

        circle.printArea("Circle");
        rectangle.printArea("Rectangle");

        circle.printArea();
    }
}
