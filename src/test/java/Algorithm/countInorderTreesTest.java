package Algorithm;

import Algorithm.tree.countInorderTrees;
import org.junit.Test;

/**
 * Created by kevin on 2016/4/6.
 */
public class countInorderTreesTest {
    @Test
    public void test() {
        countInorderTrees inorderTrees = new countInorderTrees();
        int res = inorderTrees.inorderTreeNums(4);
        System.out.println(res);
    }
}
