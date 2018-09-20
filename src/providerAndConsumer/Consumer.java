package providerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-13 17:00
 **/
public class Consumer implements Runnable{
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start consumer id = " + Thread.currentThread().getId());
        try {
            while (true) {
                String s = queue.take();
                    System.out.println("=======" + s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
