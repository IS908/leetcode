package leetcode;

import java.util.*;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @Date: 2019-06-02 11:03
 */
public class L046_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> lists = new LinkedList<>();
        lists.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = lists.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = lists.pop();
                for (int k = 0; k <= i; k++) {
                    LinkedList<Integer> integers = new LinkedList<>(list);
                    integers.add(k, nums[i]);
                    lists.addLast(integers);
                }
            }
        }
        Collections.sort(lists, List::indexOf);
        return lists;
    }

    // TODO: 递归实现
}
