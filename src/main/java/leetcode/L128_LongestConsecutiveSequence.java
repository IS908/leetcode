package leetcode;

import java.util.HashSet;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p/>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p/>
 * Your algorithm should run in O(n) complexity.
 * <p/>
 * Created by kevin on 2016/3/4.
 */
public class L128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxCount = 0, currentCount;
        for (int i : nums) set.add(i);
        for (int i : nums) {
            while (set.contains(i)) {
                set.remove(i);
                currentCount = 1;
                for (int j = i + 1; set.contains(j); j++){
                    set.remove(j);
                    currentCount++;
                }
                for (int j = i - 1; set.contains(j); j--){
                    set.remove(j);
                    currentCount++;
                }
                maxCount = maxCount < currentCount ? currentCount : maxCount;
            }
        }
        return maxCount;
    }
}
