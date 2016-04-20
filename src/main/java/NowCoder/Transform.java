package NowCoder;

/**
 * Created by kevin on 2016/4/19.
 */
public class Transform {
    public String trans(String s, int n) {
        // 翻转单词
        String[] strs = s.substring(0, n).split(" ");
        StringBuilder sb = new StringBuilder();
        if (s.charAt(n - 1) == ' ') sb.append(" ");
        for (int i = strs.length - 1; i > 0; i--) {
            sb.append(strs[i] + " ");
        }
        sb.append(strs[0]);

        // 大小写转换
        char[] chars = sb.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

}
