package JavaBasicKnowledge;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * Created by kevin on 2016/3/21.
 */
public class ThrowOOD {
    public static void main(String[] args) {
        boolean[] arr = new boolean[501];
        int count = 501;
        int current = 0;
        boolean flag = false;
        while (count > 1) {
            current = current % 501;
            if (flag) {
                while (arr[current % 501]) current++;
                arr[current % 501] = true;
                count--;
            }
            flag = !flag;
        }
        current = 0;
        while (arr[current % 501])  current++;
        System.out.println(current);
        System.out.println(arr[current]);
        System.out.println(arr[current-1]);
        System.out.println(Integer.toBinaryString(6128));
        System.out.println(Integer.toBinaryString(9091));
        System.out.println(Integer.toBinaryString(9825));
    }
}
