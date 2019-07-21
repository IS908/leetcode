package JDK.JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description: // TODO
 * @Auther: kun
 * @Date: 2019-06-17 12:44
 */
public class CountDownLatchDemo {
    CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) {
        CountDownLatchDemo demo = new CountDownLatchDemo();

        Thread thread = new Thread(() -> {
            demo.latch.countDown();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.latch.countDown();
        });

        thread.start();

        try {
            demo.latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
