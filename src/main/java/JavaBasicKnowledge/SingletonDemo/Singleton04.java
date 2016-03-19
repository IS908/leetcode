package JavaBasicKnowledge.SingletonDemo;

/**
 * 内部类模式
 * 使用内部类可以解决过早初始化问题
 * Created by kevin on 16-3-19.
 */
public class Singleton04 {

    private Singleton04() {}

    public static Singleton04 getInstance() {
        return Nested.instance;
    }

    private static class Nested{
        static Singleton04 instance = new Singleton04();
    }

    @Override
    public String toString() {
        return "静态内部类方式实现单例模式，解决了对象初始化过早的问题";
    }
}
