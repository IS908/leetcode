package JavaBasicKnowledge.test;

import java.util.StringTokenizer;

/**
 * Created by kevin on 16-8-10.
 */
public class TestStringTokenizer {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(" Welcome to our country ");
        System.out.println(st.countTokens());
//        while (st.hasMoreTokens()) {
//            System.out.println(st.nextToken());
//        }
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }
    }
}
