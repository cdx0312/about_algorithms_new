package providerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-13 16:51
 **/
public class Provider implements Runnable{

    private BlockingQueue<String> queue;

    private volatile boolean isRunning = true;

    private static AtomicInteger count = new AtomicInteger(100);

    public Provider(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start producer id = " + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(1000);
                String s = String.valueOf(count.incrementAndGet());
                if (!queue.offer(s, 2, TimeUnit.SECONDS))
                    System.err.println("fail to add in blockQueue");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        isRunning =false;
    }
}
