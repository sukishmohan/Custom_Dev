// extends: Developer inherits from Employee.
public class Developer extends Employee {
    public Developer(String name, double salary) {
        // super calls the Employee constructor.
        super(name, salary);
    }

    public void writeCode() {
        System.out.println(name + " writes Java code.");
    }
}
