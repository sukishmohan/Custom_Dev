
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    public static void main(String[] args) {

        // Create a thread pool with 2 threads
        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        // Submit tasks
        for (int i = 1; i <= 5; i++) {

            int taskId = i;

            executor.submit(() -> {
                System.out.println(
                    "Task " + taskId +
                    " executed by " +
                    Thread.currentThread().getName()
                );
            });
        }

        // Stop accepting new tasks
        executor.shutdown();
    }
}
