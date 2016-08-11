package JVM.JVMClassLoader;

/**
 * Created by kevin on 16-8-7.
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
        System.out.println(Thread.currentThread().isDaemon());
//        SuperClass[] sca = new SuperClass[10];
//        SubClass[] sba = new SubClass[10];
//        System.out.println(ConstClass.HELLOWORLD);
//        System.out.println(System.getProperty("java.home"));
//        System.out.println(System.getProperty("java.vm.specification.version"));
//        System.out.println(System.getProperty("java.library.path"));
    }
}
