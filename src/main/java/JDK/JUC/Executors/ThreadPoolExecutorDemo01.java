package JDK.JUC.Executors;

import java.util.concurrent.*;

/**
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
 * <p>
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 * <p>
 * Created by kevin on 16-8-16.
 */
public class ThreadPoolExecutorDemo01 {
    public static void main(String[] args) {
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService cachedThreadPool =
                new ThreadPoolExecutor(
                        0, // 保留的线程池大小
                        Integer.MAX_VALUE, // 线程池的最大大小
                        60L, // 空闲线程结束的超时时间
                        TimeUnit.SECONDS, // keepAliveTime 结束超时时间的单位
                        new SynchronousQueue<Runnable>(),    // 工作队列
                        Executors.defaultThreadFactory(),   //
                        new ThreadPoolExecutor.AbortPolicy()    // 拒绝策略
                );
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(index);
                }
            });

        }
    }
}
