package JDK.JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Description: // TODO
 * @Auther: kun
 * @Date: 2019-06-17 12:48
 */
public class CyclicBarrierDemo {

    CyclicBarrier barrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    demo.barrier.await();
                    System.out.println("thread 1 pair: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    demo.barrier.await();
                    System.out.println("thread 2 pair: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }

        });

        thread1.start();
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(2);
    }


}
