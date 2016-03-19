package JavaBasicKnowledge.ProducerConsumer;

import java.util.LinkedList;

/**
 * Created by kevin on 16-3-19.
 */
public class Procucer extends Thread {
    public LinkedList<String> linkedList;

    public Procucer(LinkedList<String> linkedList) {
        this.linkedList = linkedList;
    }

    public void run(){

    }
}
