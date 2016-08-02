package JavaBasicKnowledge;

/**
 * Created by kevin on 16-6-5.
 */
public class VolatileDemo {
    public volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        final VolatileDemo volatileDemo = new VolatileDemo();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (volatileDemo.flag == false) {
                        volatileDemo.flag = true;
                        System.out.println("thread run");
                    }
                }

            }
        });

        Thread task = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (volatileDemo.flag == true) {
                        volatileDemo.flag = false;
                        System.out.println("task run");
                    }
                }

            }
        });

        thread.start();
        task.start();

        Thread.sleep(1000);
        System.out.println("done!");
    }
}
