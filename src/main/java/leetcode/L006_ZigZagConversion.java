package leetcode;

import java.util.Arrays;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p/>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p/>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * <p/>
 * Created by kevin on 2016/2/24.
 */
public class L006_ZigZagConversion {

    public String convert(String s, int numRows) {
        int len = s.length();
        if (len == 0 || numRows <= 1) {
            return s;
        }

        String[] ans = new String[numRows];
        Arrays.fill(ans, "");
        int row = 0, delta = 1;
        for (int i = 0; i < len; i++) {
            ans[row] += s.charAt(i);
            row += delta;
            if (row >= numRows) {
                row = numRows - 2;
                delta = -1;
            }
            if (row < 0) {
                row = 1;
                delta = 1;
            }
        }

        String ret = "";
        for (int i = 0; i < numRows; i++) {
            ret += ans[i];
        }
        return ret;
    }


//    public String convert2(String s, int numRows) {
//        int len = s.length();
//
//        String[] strs = new String[numRows];
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < numRows - 1; i++) {
//            for (int j = i; j < len; j = j + numRows * 2 - 2) {
//                sb.append(s.charAt(j));
//                int index = j + (numRows - 1 - (j % numRows)) * 2;
//                if (index < len) {
//                    sb.append(s.charAt(index));
//                }
//            }
//            strs[i] = sb.toString();
//            sb.setLength(0);
//        }
//
//        for (int i = 0; i < len; i = i + 2 * numRows - 2) {
//            sb.append(s.charAt(i));
//        }
//        strs[0] = sb.toString();
//        sb.setLength(0);
//        for (int i = numRows - 1; i < len; i = i + 2 * numRows - 2) {
//            sb.append(s.charAt(i));
//        }
//        strs[numRows - 1] = sb.toString();
//        sb.setLength(0);
//        for (int i = 0; i < numRows; i++) {
//            sb.append(strs[i]);
//        }
//
//        return sb.toString();
//    }

}
