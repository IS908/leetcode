package NowCoder.NetEase;

/**
 * Created by kevin on 16-8-2.
 */
public class test {
    public static void main(String[] args) {
        dog d = new dog();
        hashiqi h = new hashiqi();
        d.bark();
        h.bark();
    }
}

class dog{
    public static void bark() {
        System.out.println("dog");
    }
}

class hashiqi extends dog{
    public static void bark() {
        System.out.println("hashiqi");
    }
}
