package Algorithm.string;

/**
 * @Description: 字符串的统计字符串
 * <p>
 * 给定一个字符串str，返回str的统计字符串。
 * 例如，"aaabbadddffc"的统计字符串为"a_3_b_2_a_1_d_3_f_2_c_1"。
 * @Auther: kun
 * @Date: 2019-07-27 11:40
 */
public class StringCount {

    public String getCountString(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chs = str.toCharArray();
        String res = String.valueOf(chs[0]);
        int num = 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != chs[i - 1]) {
                res = concat(res, String.valueOf(num), String.valueOf(chs[i]));
                num = 1;
            } else {
                num++;
            }
        }
        return concat(res, String.valueOf(num), "");
    }

    public String concat(String s1, String s2, String s3) {
        return s1 + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);
    }

}
