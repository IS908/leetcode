package JavaBasicKnowledge.SingletonDemo;

/**
 * 懒汉模式
 * 保证多线程情况下正常运行，但是加同步效率低下
 * Created by kevin on 16-3-19.
 */
public class Singleton02 {
    private static Singleton02 Instance;

    private Singleton02() {}

    public static synchronized Singleton02 getInstance() {
        if (Instance == null) {
            Instance = new Singleton02();
        }
        return Instance;
    }

    public String toString(){
        return "懒汉加同步方式实现的单例模式，保证多线程下正常运行，但是同步效率降低";
    }
}
