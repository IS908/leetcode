package JavaBasicKnowledge.thread;

/**
 * Created by kevin on 16-8-7.
 */
public class ThreadTest implements Runnable {
    @Override
    public void run() {
        System.out.println("I'm running!");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread threadTest = new Thread(new ThreadTest());
        threadTest.start();
        Thread test = new Thread(new ThreadTest());
        test.start();
        System.out.println(Thread.currentThread().getName());
        byte[] bytes = new byte[1];
    }
}
