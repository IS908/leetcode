package JavaBasicKnowledge;

import java.util.ArrayList;
import java.util.List;

/**
 * 多态性
 * Created by kevin on 2016/3/11.
 */
public class GenericDemo {

    public void test() {
        List<? extends Fruit> list01 = new ArrayList<>();
        //list01.add(new Plant());
        //list01.add(new RedApple());
        //list01.add(new Apple());
        //list01.add(new Fruit());

        List<? super Fruit> list02 = new ArrayList<>();
        //list02.add(new Plant());
        list02.add(new Fruit());
        list02.add(new Apple());
        list02.add(new RedApple());
    }
}

class Plant {
}

class Fruit extends Plant {
}

class Apple extends Fruit {
}

class RedApple extends Apple {
}
