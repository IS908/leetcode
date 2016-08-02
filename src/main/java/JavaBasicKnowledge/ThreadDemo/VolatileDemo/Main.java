package JavaBasicKnowledge.ThreadDemo.VolatileDemo;

/**
 * Created by kevin on 16-6-5.
 */
public class Main {
    public static void main(String[] args) {
        Pojo pojo = new Pojo();
        Thread taskA = new Thread(new TaskA(pojo));
        Thread taskB = new Thread(new TaskB(pojo));
        taskA.start();
        taskB.start();
        System.out.println("Main done!");
    }
}
