package JavaBasicKnowledge.test;

/**
 * Created by kevin on 16-8-10.
 */
public class TestTryCatchFinally {
    public static int testFinally1() {
        int result = 1;
        try {
            result = 2;
            return result;
        } catch (Exception e) {
            return 0;
        } finally {
            result = 3;
            System.out.println("execute finally1");
        }
    }

    public static StringBuilder testFinally2() {
        StringBuilder sb = new StringBuilder("Hello");
        try {
            return sb;
        } catch (Exception e) {
            return null;
        } finally {
            sb.append(" World");
            System.out.println("execute finally2");
        }
    }

    public static void main(String[] args) {
        int resultVal = testFinally1();
        System.out.println(resultVal);
        StringBuilder sb = testFinally2();
        System.out.println(sb);
    }
}
