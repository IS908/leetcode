package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 16-8-25.
 */
public class L089_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) list.add(i ^ (i >>> 1));
        return list;
    }
}
