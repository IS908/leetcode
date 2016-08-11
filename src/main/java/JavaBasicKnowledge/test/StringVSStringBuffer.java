package JavaBasicKnowledge.test;

/**
 * Created by kevin on 16-8-10.
 */
public class StringVSStringBuffer {
    public static void testString() {
        String s = "Hello";
        String s1 = "World";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s += s1;
        }
        long end = System.currentTimeMillis();
        long runTime = end - start;
        System.out.println("testString:" + runTime);
    }

    public static void testStringBuffer() {
        StringBuffer sb = new StringBuffer("Hello");
        String s1 = "World";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append(s1);
        }
        long end = System.currentTimeMillis();
        long runTime = end - start;
        System.out.println("testStringBuffer:" + runTime);
    }

    public static void main(String[] args) {
        testString();
        testStringBuffer();
    }
}
