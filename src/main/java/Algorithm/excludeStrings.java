package Algorithm;

/**
 * 去除字符串S1中的字符使得字符串S2中不包含‘ab’和'c'
 * <p/>
 * Created by kevin on 2016/4/6.
 */
public class excludeStrings {
    public String excludeStr(String S1) {
        char[] chs = S1.toCharArray();
        char[] res = new char[chs.length];
        int i = 0, j = 0;
        while (i < chs.length) {
            switch (chs[i]) {
                case 'c':
                    i++;
                    break;
                case 'a':
                    int[] m = excludeStr(chs, i, res, j);
                    i = m[0];
                    j = m[1];
                    break;
                default:
                    res[j++] = chs[i++];
                    break;
            }
        }
        return String.valueOf(res).substring(0, j);
    }

    private int[] excludeStr(char[] chs, int a, char[] res, int cur) {
        int i = a, j = a + 1;
        while (i >= 0 && j < chs.length) {
            if (chs[i] != 'a') {
                break;
            } else if (chs[j] == 'a') {
                i = j++;
            } else if (chs[j] == 'b') {
                i--;
                j++;
            } else if (chs[j] == 'c') {
                j++;
            } else {
                break;
            }
        }

        while (a <= i) {
            res[cur++] = chs[a++];
        }
        return new int[]{j, cur};
    }

}
