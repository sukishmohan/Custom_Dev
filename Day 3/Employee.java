public class Employee {
    // protected: child classes can use this field.
    protected String name;

    // private: only Employee can use this field directly.
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}
