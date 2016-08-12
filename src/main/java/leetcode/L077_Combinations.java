package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 16-8-12.
 */
public class L077_Combinations {

    // 递归解决方案
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combine(lists, list, 1, 0, n, k);
        return lists;
    }

    private void combine(List<List<Integer>> lists, List<Integer> list, int start, int cur, int n, int k) {
        if (cur == k) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            combine(lists, list, i + 1, cur + 1, n, k);
            list.remove(list.size() - 1);
        }

    }

    // 迭代解决方案
    public List<List<Integer>> combine1(int n, int k) {

        return null;
    }
}
