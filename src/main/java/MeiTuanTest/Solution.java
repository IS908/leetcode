package MeiTuanTest;

/**
 * Created by kevin on 2016/3/21.
 */
public class Solution {
    public void printMap(int mapsize) {
        if (mapsize == 1) {
            System.out.println("#");
            return;
        }
        int num = (int) Math.pow(3, mapsize - 1);
        boolean[][] arr = new boolean[num + 1][num + 1];    // 空出第0行和第0列
        // 开始构造图形
        drawPicture(arr, mapsize - 1, 1, num, 1, num);

        // 打印图形
        printMap(arr);
    }

    /**
     * 构造图形
     *
     * @param arr 画图数组
     * @param n   当前的mapsize
     * @param p1  上行
     * @param p2  下行
     * @param p3  左列
     * @param p4  右列
     */
    private void drawPicture(boolean[][] arr, int n, int p1, int p2, int p3, int p4) {
        if (n == 1) {
            arr[p1][p3] = true;
            arr[p1][p4] = true;
            arr[p1 + 1][p3 + 1] = true;
            arr[p2][p3] = true;
            arr[p2][p4] = true;
        } else {
            int rowdiff = (int) Math.pow(3, n - 1);
            int coldiff = (int) Math.pow(3, n - 1);
            drawPicture(arr, n - 1, p1, p1 + rowdiff - 1, p3, p3 + coldiff - 1);    // 左上
            drawPicture(arr, n - 1, p1, p1 + rowdiff - 1, p4 - coldiff + 1, p4);    // 右上
            drawPicture(arr, n - 1, p1 + rowdiff, p2 - rowdiff, p3 + coldiff, p4 - coldiff);    // 中间
            drawPicture(arr, n - 1, p2 - rowdiff + 1, p2, p3, p3 + coldiff - 1);    // 左下
            drawPicture(arr, n - 1, p2 - rowdiff + 1, p2, p4 - coldiff + 1, p4);    // 右下
        }
    }

    // 打印图形
    private void printMap(boolean[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j]) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.printMap(4);
    }
}
