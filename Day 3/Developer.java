public class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }

    public void writeCode() {
        System.out.println(name + " writes Java code.");
    }
}
