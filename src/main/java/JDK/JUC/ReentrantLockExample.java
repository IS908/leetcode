package JDK.JUC;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: // TODO
 * @Auther: kun
 * @Date: 2019-06-02 21:24
 */
public class ReentrantLockExample {
    int a;
    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock();
        try {
            a++;
        } finally {
            lock.unlock();
        }
    }

    public void reader() {
        lock.lock();
        try {
            int i = a;
            System.out.println(i);
        } finally {
            lock.unlock();
        }
    }
}
