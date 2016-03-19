package JavaBasicKnowledge.SingletonDemo;

import java.io.Serializable;

/**
 * 懒汉模式
 * 多线程下会存在问题，需加锁同步【见Singleton02】
 * Created by kevin on 16-3-19.
 */
public class Singleton01 implements Serializable {
    private transient static Singleton01 instance;

    private Singleton01() {}

    public static Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }

    private Singleton01 readResolve() {
        return instance;
    }

    public String toString(){
        return "懒汉不加同步方式实现的单例模式";
    }
}
