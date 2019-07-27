package Algorithm.recursionAndDynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 数组中的最长连续序列
 * <p>
 * 给定无序数组arr，返回其中最长的连续序列的长度。
 * <p>
 * 例如：arr=[100，4，200，1，3，2]，最长的连续序列为[1，2，3，4]，所以返回4。
 * @Auther: kun
 * @Date: 2019-07-26 18:46
 */
public class MaxSubContinuanceSequence {

    public int longestConsecutive1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                if (map.containsKey(arr[i] - 1)) {
                    max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
                }
                if (map.containsKey(arr[i] + 1)) {
                    max = Math.max(max, merge(map, arr[i], arr[i] + 1));
                }
            }
        }
        return max;
    }

    public int merge(HashMap<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }

    /**
     * 时间复杂度 O(N)
     * @param arr
     * @return
     */
    public int longestConsecutive2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            }
        }
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int count = 1;
            int left = cur - 1;
            int right = cur + 1;
            if (!set.contains(cur)) {
                continue;
            }
            set.remove(cur);
            while (set.contains(left)) {
                set.remove(left--);
                count++;
            }
            while (set.contains(right)) {
                set.remove(right++);
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
