package NowCoder.NetEase;

import java.util.*;

/**
 * Created by kevin on 16-8-2.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strs = line.split(",");
        int[] numbers = new int[strs.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(strs[i].trim());
        }
        List<List<Integer>> lists = subsets(numbers);
        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.size() > o2.size())
                    return 1;
                else if (o1.size() < o2.size())
                    return -1;
                else {
                    for (int i = 0; i < o1.size(); i++) {
                        if (o1.get(i) > o2.get(i))
                            return 1;
                        else if (o1.get(i) < o2.get(i))
                            return -1;
                    }
                }
                return 0;
            }
        });
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsets(nums, nums.length - 1, list, lists);
        return lists;
    }

    private static void subsets(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
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
