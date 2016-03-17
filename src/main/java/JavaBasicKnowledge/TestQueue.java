package JavaBasicKnowledge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kevin on 16-3-17.
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Hello");
        queue.offer("World!");
        queue.offer("你好！");
        System.out.println(queue.size());
        String str;
        while((str=queue.poll())!=null){
            System.out.println(str);
        }
        System.out.println();
        System.out.println(queue.size());
    }
}
