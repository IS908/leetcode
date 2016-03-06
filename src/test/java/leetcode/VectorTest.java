package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by kevin on 2016/3/2.
 */
public class VectorTest {
    @Test
    public void test() {
        Vector v = new Vector();
        v.add(2);
        v.add(3);
        System.out.println(v.size());
        for (Object tmp : v) {
            System.out.println((int)tmp);
        }
        System.out.println(v.get(0));
    }

    @Test
    public void testHashTable() {
        Hashtable<String, String> table = new Hashtable<>();

    }

    @Test
    public void testLinkedList() {
        LinkedList<String>  linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");

        Iterator<String> iterator = linkedList.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Iterator<String> it = linkedList.listIterator();

        Stack<String> stack = new Stack<>();
        stack.remove(0);
        HashSet<String> hc = new HashSet<>();
    }
}
