package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: Given a collection of candidate numbers (candidates) and a target number (target), <br/>
 * find all unique combinations in candidates where the candidate numbers sums to target.<br/>
 * Each number in candidates may only be used once in the combination.
 * @Auther: kun
 * @Date: 2019-06-26 09:08
 */
public class L040_CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum2(candidates, result, list, 0, target);
        return result;
    }

    private void combinationSum2(int[] candidates, List<List<Integer>> result, List<Integer> list,
                                 int start, int remain) {
        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            List<Integer> tmp = new LinkedList<>(list);
            result.add(tmp);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum2(candidates, result, list, i + 1, remain - candidates[i]);
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
            list.remove(list.size() - 1);
        }
    }
}
