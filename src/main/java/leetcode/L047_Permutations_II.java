package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * Created by kevin on 16-6-23.
 */
public class L047_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        this.fullArray(lists, list, nums);

        return null;
    }

    //private
    private void fullArray(List<List<Integer>> lists, List<Integer> current, int[] nums) {

    }
}
