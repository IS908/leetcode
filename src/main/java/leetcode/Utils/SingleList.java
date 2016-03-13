package leetcode.Utils;

/**
 * Created by kevin on 2016/3/13.
 */
public class SingleList {
    private ListNode head;
    public SingleList(int[] nums) {
        head = createList(nums);
    }

    public ListNode getHead() {
        return head;
    }

    private ListNode createList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i=1;i<nums.length;i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }
}
