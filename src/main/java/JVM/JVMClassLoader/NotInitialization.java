package JVM.JVMClassLoader;

/**
 * Created by kevin on 16-8-7.
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.val);
        SuperClass[] sca = new SuperClass[10];
        SubClass[] sba = new SubClass[10];
        System.out.println(ConstClass.HELLOWORLD);
    }
}
