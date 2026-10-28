// extends: Manager inherits from Employee.
public class Manager extends Employee {
    public Manager(String name, double salary) {
        // super calls the Employee constructor.
        super(name, salary);
    }

    public void manageTeam() {
        System.out.println(name + " manages the team.");
    }
}
