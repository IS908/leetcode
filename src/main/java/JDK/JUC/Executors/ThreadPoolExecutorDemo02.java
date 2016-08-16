package JDK.JUC.Executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 * <p>
 * 因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
 * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
 * <p>
 * Created by kevin on 16-8-16.
 */
public class ThreadPoolExecutorDemo02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            String output = fixedThreadPool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "call() Method!";
                }
            }).get();
            System.out.println(output);
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return;
    }
}
