package JavaBasicKnowledge;

/**
 * Java 异常处理
 * Created by kevin on 2016/3/16.
 */
public class ExceptionTest extends Exception {
    private static void bar() throws BlogAppException {
        System.out.println("let'a assume BlogAppException happened when executing `create` command");
        throw new BlogAppException("create");
    }

    private static void foo() throws ArithmeticException{
        int x = 5 / 0;
        System.out.println(x);
    }

    public static void main(String[] args) {
        try {
            bar();
            foo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("program is still running here!");
    }
}

class BlogAppException extends Exception {
    private static final long serialVersionUID = 1L;

    private String command;

    public BlogAppException(String command) {
        this.command = command;
    }

    public String toString() {
        return "Exception happened when executing command " + command;
    }
}
