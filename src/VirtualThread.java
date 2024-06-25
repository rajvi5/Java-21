import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Helps in writing high throughput concurrent applications.
 * 1000 times faster to launch.
 * 1000 times less memory consumption.
 * It's cheap to create virtualThread. So no need to manage thread pool, we can just let the thread die after each task
 * and create another one for new task.
 * Each traditional thread is corresponded to OS thread. Hence, can have limited platform threads per machine but can
 * have several million virtual threads on same machine.
 * Virtual threads are managed by JVM and are not tied with OS threads. Very suitable for I/O bound tasks.
 * Virtual thread uses heap memory. They uses a platform thread as a carrier.
 */

public class VirtualThread {

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();

        //Thread creation ways
        /*var Thread = new Thread();
        var pThread = Thread.ofPlatform();
        var vThread = Thread.ofVirtual();
        var executer = Executors.newFixedThreadPool(4);*/

        try(var executor = Executors.newVirtualThreadPerTaskExecutor())
        {
            IntStream.range(0,10000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
