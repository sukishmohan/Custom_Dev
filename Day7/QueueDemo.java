import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> customers = new LinkedList<>();

        customers.offer("Lokesh");
        customers.offer("Amar");
        customers.offer("Surya");

        System.out.println(customers);
        System.out.println("Next customer: " + customers.peek());
        System.out.println("Served: " + customers.poll());
        System.out.println("Remaining: " + customers);
    }
}
