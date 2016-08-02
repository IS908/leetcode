package JavaBasicKnowledge.ThreadDemo.VolatileDemo;

/**
 * Created by kevin on 16-6-5.
 */
public class TaskB implements Runnable {
    private Pojo pojo;

    public TaskB(Pojo pojo) {
        this.pojo = pojo;
    }

    @Override
    public void run() {
        while (pojo.isFlag()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId());
        }
    }
}
