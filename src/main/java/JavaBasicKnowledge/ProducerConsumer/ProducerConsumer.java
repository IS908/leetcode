package JavaBasicKnowledge.ProducerConsumer;

import java.util.LinkedList;

/**
 * Created by kevin on 2016/3/19.
 */
public class ProducerConsumer {

    private LinkedList<String> list = new LinkedList<>();
    private int max = 10;

    public void start() {
        new Producer().start();
        new Consumer().start();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    try {
                        while (list.size() == 10) {
                            System.out.println("storeHouse is full , please wait");
                            list.wait();
                        }
                        if (list.add("one product!")) {
                            System.out.println("producer produce a product! storeHouse:" + list.size());
                            Thread.sleep((long) (Math.random() * 3000));
                            list.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    try {
                        while (list.size() == 0) {
                            System.out.println("storeHouse is empty , please wait");
                            list.wait();
                        }
                        if (list.remove("one product!")) {
                            System.out.println("consumer consume a product! storeHouse:" + list.size());
                            Thread.sleep((long) (Math.random() * 3000));
                            list.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producerConsumer.start();
    }
}


