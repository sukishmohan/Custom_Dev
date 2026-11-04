class Box<T> {

    T value;

    void setValue(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }
}

public class Generic {
    public static void main(String[] args) {

        Box<String> box1 = new Box<>();
        box1.setValue("Java");

        Box<Integer> box2 = new Box<>();
        box2.setValue(100);

        System.out.println(box1.getValue());
        System.out.println(box2.getValue());
    }
}