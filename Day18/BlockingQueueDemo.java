
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args)
            throws InterruptedException {

        BlockingQueue<String> queue =
                new ArrayBlockingQueue<>(2);

        queue.put("Task 1");
        queue.put("Task 2");

        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
