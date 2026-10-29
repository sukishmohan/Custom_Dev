public class InterfaceShapeDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(2);
        Shape rectangle = new Rectangle(4, 5);

        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
    }
}
