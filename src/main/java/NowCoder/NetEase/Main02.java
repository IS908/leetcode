package NowCoder.NetEase;

import java.util.*;

/**
 * Created by kevin on 16-8-6.
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = in.nextInt();
        }
        int res = unreachableMin(arr);
        System.out.println(res);
    }

    private static int unreachableMin(int[] nums) {
        Set<Integer> set = subsets(nums);
        int res = 0;
        while (set.contains(++res));
        return res;
    }

    public static Set<Integer> subsets(int[] nums) {
        if (nums == null) return new HashSet<>();
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        countSum(nums, nums.length - 1, list, set);
        return set;
    }

    private static void countSum(int[] nums, int index, List<Integer> list, Set<Integer> result) {
        if (index == -1) {
            result.add(sum(list));
            return;
        }

        countSum(nums, index - 1, list, result);
        list.add(0, nums[index]);
        countSum(nums, index - 1, list, result);
        list.remove(0);
    }

    private static int sum(List<Integer> list){
        if (list.size() > 0) {
            int sum = 0;
            for (int tmp: list) {
                sum += tmp;
            }
            return sum;
        }
        return 0;
    }
}
