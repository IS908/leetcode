package JDK.JUC;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: // TODO
 * @Auther: kun
 * @Date: 2019-06-17 13:32
 */
public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            try {
                String A = "银行流水A";
                String B = exgr.exchange(A);
                System.out.println("A: " + A + ", B: " + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            try {
                String B = "银行流水B";
                String A = exgr.exchange("B");
                System.out.println("数据一致？：" + A.equals(B) + ", A: " + A + ", B: " + B);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.shutdown();
    }

}
