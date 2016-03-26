package JavaBasicKnowledge;

import JavaBasicKnowledge.SingletonDemo.*;
import org.junit.Test;

/**
 * Created by kevin on 16-3-19.
 */
public class SingletonTest {
    @Test
    public void test01(){
        Singleton01 singleton01 = Singleton01.getInstance();
        Singleton02 singleton02 = Singleton02.getInstance();
        Singleton03 singleton03 = Singleton03.getInstance();
        Singleton04 singleton04 = Singleton04.getInstance();
        Singleton05 singleton05 = Singleton05.INSTANCE;

        System.out.println(singleton01);
        System.out.println(singleton02);
        System.out.println(singleton03);
        System.out.println(singleton04);
        System.out.println(singleton05.toString());
    }
}
