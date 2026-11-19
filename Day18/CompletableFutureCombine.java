
import java.util.concurrent.CompletableFuture;

public class CompletableFutureCombine {

    public static void main(String[] args) {

        CompletableFuture<Integer> task1 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Calculating marks...");
                    return 80;
                });

        CompletableFuture<Integer> task2 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Calculating bonus...");
                    return 10;
                });

        CompletableFuture<Integer> total =
                task1.thenCombine(task2, (marks, bonus) ->
                        marks + bonus
                );

        System.out.println("Total: " + total.join());
    }
}
