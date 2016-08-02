package JavaBasicKnowledge.ThreadDemo.VolatileDemo;

/**
 * Created by kevin on 16-6-5.
 */
public class Pojo {
    private volatile boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
