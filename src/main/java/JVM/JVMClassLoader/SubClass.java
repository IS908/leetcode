package JVM.JVMClassLoader;

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
    public static int val = 321;
}
