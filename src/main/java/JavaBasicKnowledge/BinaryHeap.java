package JavaBasicKnowledge;

import javax.crypto.Cipher;
import java.nio.BufferUnderflowException;

/**
 * 二项堆的数据结构及相关操作类
 * <p/>
 * Created by kevin on 16-3-17.
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;    // 当前数组中元素的个数（下标从1开始算）
    private AnyType[] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        array = (AnyType[]) new Comparable[capacity];
        currentSize = 1;
    }

    public BinaryHeap(AnyType[] items) {
        currentSize = items.length - 1;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (AnyType item : items) array[i++] = item;
        buildHeap();
    }

    public void insert(AnyType x) {
        if (currentSize == array.length - 1) {// 数组已满
            enlargeArray(array.length * 2 + 1);
        }
        int hole = ++currentSize;
        while (hole > 1 && x.compareTo(array[hole / 2]) < 0) {
            array[hole] = array[hole / 2];
            hole /= 2;
        }
        array[hole] = x;
    }

    public AnyType findMin() {
        if (currentSize < 1) return null;
        return array[1];
    }

    public AnyType deleteMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        AnyType res = array[1];
        array[1] = array[currentSize--];
        percolateDown(1);
        return res;
    }

    public boolean isEmpty() {
        return currentSize < 1;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];
        while (hole * 2 <= currentSize) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) child++;
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else break;
            hole = child;
        }
        array[hole] = tmp;
    }

    /**
     * 将现有数组变为二项堆
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    private void enlargeArray(int newSize) {
        if (array.length > newSize)
            throw new BufferUnderflowException();
        AnyType[] tmp = (AnyType[]) new Comparable[newSize];
        for (int i = 1; i < array.length; i++)
            tmp[i] = array[i];
        array = tmp;
    }
}
