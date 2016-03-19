package JavaBasicKnowledge.ProducerConsumer;

import java.util.LinkedList;

/**
 * Created by kevin on 16-3-19.
 */
public class Consumer extends Thread{
    public LinkedList<Object> list;

    public Consumer(LinkedList<Object> list) {
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
    }
}
