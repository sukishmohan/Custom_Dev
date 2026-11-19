public class Main {
    record Employee(int id, String name, String role) {}

    public static void main(String[] args) {
        Employee employee = new Employee(101, "Arun", "Developer");

        System.out.println(employee.id());
        System.out.println(employee.name());
        System.out.println(employee.role());
        System.out.println(employee); // generated toString()
    }
}
