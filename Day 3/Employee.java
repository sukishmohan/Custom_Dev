public class Employee {
    protected String name;

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
