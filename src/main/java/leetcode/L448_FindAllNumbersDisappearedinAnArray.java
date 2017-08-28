package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2017-08-28 20:18.
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 *
 * 思路：在原数组上进行置换操作，将每个数字与其角标对应起来，不对应的便是缺少的数字
 */
public class L448_FindAllNumbersDisappearedinAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = nums[i];
            while (index != nums[index - 1] && index != (i + 1)) {
                int tmp = nums[index - 1];
                nums[index - 1] = index;
                nums[i] = tmp;
                index = nums[i]; // 更新index值
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) list.add(i + 1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        L448_FindAllNumbersDisappearedinAnArray findAllNumbersDisappearedinAnArray = new L448_FindAllNumbersDisappearedinAnArray();
        List<Integer> list = findAllNumbersDisappearedinAnArray.findDisappearedNumbers(arr);
        System.out.println(list);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
