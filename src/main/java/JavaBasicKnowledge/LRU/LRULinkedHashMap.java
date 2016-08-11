package JavaBasicKnowledge.LRU;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建LRUCache类重写removeEldestEntry方法并且将put/get操作添加互斥操作
 * <p>
 * Created by kevin on 16-8-11.
 */
@Deprecated
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = -1113585794513867526L;
    private final int maxCapacity;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final Lock lock = new ReentrantLock();

    public LRULinkedHashMap(int initialCapacity, int maxCapacity) {
        super(initialCapacity, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }

    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        } finally {
            lock.unlock();
        }
    }

    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    ;
}
