package JavaBasicKnowledge;

/**
 * 继承情况下了类个类型成员初始化顺序
 * Created by kevin on 2016/3/7.
 */
public class InitialOrderTest2 extends Parent {
    // 静态变量
    public static String s_StaticField = "子类--静态变量";
    // 变量
    public String s_Field = "子类--变量";
    // 静态初始化块
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }
    // 初始化块
    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }
    // 构造器
    public InitialOrderTest2() {
        System.out.println("子类--构造器");
    }
    // 程序入口
    public static void main(String[] args) {
        new InitialOrderTest2();
    }
}

class Parent {
    // 静态变量
    public static String p_StaticField = "父类--静态变量";
    // 变量
    public String p_Field = "父类--变量";

    // 静态初始化块
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态初始化块");
    }

    // 初始化块
    {
        System.out.println(p_Field);
        System.out.println("父类--初始化块");
    }

    // 构造器
    public Parent() {
        System.out.println("父类--构造器");
    }
}
