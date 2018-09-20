package providerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-13 17:04
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        Provider p1 = new Provider(queue);
        Provider p2 = new Provider(queue);
        Provider p3 = new Provider(queue);
        Provider p4 = new Provider(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);
        Consumer c4 = new Consumer(queue);
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(p1);
        es.submit(p2);
        es.submit(p3);
        es.submit(p4);
        es.submit(c1);
        es.submit(c2);
        es.submit(c3);
        es.submit(c4);
        Thread.sleep(10 * 1000);
        p1.stop();
        p2.stop();
        p3.stop();
        p4.stop();
        es.shutdown();
    }
}
