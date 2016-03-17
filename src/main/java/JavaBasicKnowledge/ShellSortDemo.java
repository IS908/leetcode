package JavaBasicKnowledge;

/**
 * 希尔排序 示例
 * Created by kevin on 2016/3/10.
 */
public class ShellSortDemo {
    public void shellsort(int[] nums) {
        int j;
        for (int gap = nums.length / 2; gap > 0; gap--) {
            for (int i = gap; i < nums.length; i++) {
                int tmp = nums[i];
                for (j = i; j >= gap && tmp > nums[j - gap]; j -= gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = tmp;
            }
        }
    }
}
