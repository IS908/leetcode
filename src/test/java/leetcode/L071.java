package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/16.
 */
public class L071 {
    @Test
    public void test() {
        L071_SimplifyPath simplifyPath = new L071_SimplifyPath();
        String path = "/abc/...";
        String res = simplifyPath.simplifyPath(path);
        System.out.println(res);
    }
}
