package Algorithm.recursionAndDynamic;

/**
 * @Description: 跳跃游戏
 * <p>
 * 给定数组arr，arr[i]==k代表可以从位置i向右跳1~k个距离。
 * <p>
 * 比如，arr[2]==3，代表从位置2可以跳到位置3、位置4或位置5。如果从位置0出发，返回最少跳几次能跳到arr最后的位置上。”
 * @Auther: kun
 * @Date: 2019-07-26 18:36
 */
public class Jump {

    public int jump(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int jump = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }

}
