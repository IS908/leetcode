package JavaBasicKnowledge.SingletonDemo;

/**
 * 枚举类型实现单例模式
 * 单元素的枚举类型已经成为实现Singleton的最佳方法
 * Created by kevin on 16-3-19.
 */
public enum Singleton05 {
    INSTANCE;

    @Override
    public String toString() {
        return "枚举类型方式实现单例模式，推荐方式";
    }
}
