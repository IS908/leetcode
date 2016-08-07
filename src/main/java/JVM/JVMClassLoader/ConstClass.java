package JVM.JVMClassLoader;

/**
 * Created by kevin on 16-8-7.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world!";
}
