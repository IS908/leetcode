package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), <br/>
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * @Auther: kun
 * @Date: 2019-06-18 22:51
 */
public class L039_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum(candidates, result, list, 0, target);
        return result;
    }

    private void combinationSum(int[] candidates, List<List<Integer>> result,
                                List<Integer> list, int start, int remain) {
        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            result.add(new LinkedList<>(list));
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, result, list, i, remain - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
