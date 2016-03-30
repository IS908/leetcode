package JavaBasicKnowledge.Concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kevin on 2016/3/28.
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(6);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(2000);
    }
}

class Producer implements Runnable {

    protected BlockingQueue<String> queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                queue.put(String.valueOf(i));
                System.out.println("生产：" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    protected BlockingQueue<String> queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String num;
            while ((num = queue.take()) != null)
                System.out.println("消费：" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
