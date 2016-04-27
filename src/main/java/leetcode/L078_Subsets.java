package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p/>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p/>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p/>
 * Created by kevin on 2016/4/26.
 */
public class L078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsets(nums, nums.length - 1, list, lists);
        return lists;
    }

    private void subsets(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
        if (index == -1) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        subsets(nums, index - 1, list, result);
        list.add(0, nums[index]);
        subsets(nums, index - 1, list, result);
        list.remove(0);
    }
}
