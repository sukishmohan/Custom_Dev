
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        // Execute task asynchronously
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Fetching user details...");

                    return "Sukish";
                });

        // Process the result
        future.thenApply(name ->
                "Welcome " + name
        )
        .thenAccept(result ->
                System.out.println(result)
        );

        // Wait until the asynchronous task completes
        future.join();
    }
}
