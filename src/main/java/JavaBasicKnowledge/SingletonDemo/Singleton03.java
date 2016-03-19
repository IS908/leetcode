package JavaBasicKnowledge.SingletonDemo;

/**
 * 饿汉模式
 * 在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快
 * 对象过早初始化，可能用不到时也进行了初始化
 * Created by kevin on 16-3-19.
 */
public class Singleton03 {
    private static final Singleton03 instance = new Singleton03();

    private Singleton03() {}

    public static Singleton03 getInstance() {
        return instance;
    }

    public String toString(){
        return "饿汉方式实现的单例模式，在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快";
    }
}
