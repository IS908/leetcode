package JavaBasicKnowledge.ThreadDemo.VolatileDemo;

/**
 * Created by kevin on 16-6-5.
 */
public class TaskA implements Runnable {
    private Pojo pojo;

    public TaskA(Pojo pojo) {
        this.pojo = pojo;
    }

    @Override
    public void run() {
        while (pojo.isFlag()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId());
            pojo.setFlag(false);
        }
    }
}
