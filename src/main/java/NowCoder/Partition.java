package NowCoder;

/**
 * Created by kevin on 2016/4/19.
 */
public class Partition {
    public int[] getPartition(int[][] land, int n, int m) {
        int res = 0, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    count++;
                }
            }
        }
        int curCount = count;
        for (int i = 0; i < n; i++) {
            int count1 = 0;
            for (int j = 0; j < m; j++) {
                if (land[j][i] == 1) count1++;
            }
            curCount = curCount + 2 * count1 - m;
            if (curCount < count) {
                res = i + 1;
                count = curCount;
            }
        }
        return new int[]{res, res + 1};
    }
}
