package Algorithm;

import org.junit.Test;

/**
 * Created by kevin on 2016/4/6.
 */
public class excludeStringTest {
    @Test
    public void test() {
        excludeStrings excludeStr = new excludeStrings();
        String str = "abaaaacbbbdefacbaabbacbacbacb";
        String res = excludeStr.excludeStr(str);
        System.out.println(res);
    }
}
