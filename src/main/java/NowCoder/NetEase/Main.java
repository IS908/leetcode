package NowCoder.NetEase;

import java.util.*;

/**
 * Created by kevin on 16-8-6.
 */
public class Main {

    private static Set<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        if (number < 0) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = in.nextInt();
        }
        subsets(arr);
        System.out.println(set.size());
    }

    private static void subsets(int[] nums) {
        if (nums == null) return;
        List<Integer> list = new ArrayList<>();
        subsets(nums, nums.length - 1, list);
    }

    // 递归获得所有子序列将符合幸运数列的list加到set中
    private static void subsets(int[] nums, int index, List<Integer> list) {
        if (index == -1) {
            if (!list.isEmpty() && isLucky(list)) {
                Collections.sort(list);
                set.add(list);
            }
            return;
        }

        subsets(nums, index - 1, list);
        list.add(0, nums[index]);
        subsets(nums, index - 1, list);
        list.remove(0);
    }

    // 判断该数列是否是幸运数
    private static boolean isLucky(List<Integer> list) {
        if (list.size() == 0)
            return false;
        int sum = 0, mix = 1;
        for (int tmp : list) {
            sum += tmp;
            mix *= tmp;
        }
        return sum > mix;
    }
}
