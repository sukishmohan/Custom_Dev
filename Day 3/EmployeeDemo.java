public class EmployeeDemo {
    public static void main(String[] args) {
        Manager manager = new Manager("Ravi", 50000);
        Developer developer = new Developer("Priya", 40000);

        manager.showDetails();
        manager.manageTeam();

        System.out.println();

        developer.showDetails();
        developer.writeCode();
    }
}
