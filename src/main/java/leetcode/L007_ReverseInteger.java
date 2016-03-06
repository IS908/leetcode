package leetcode;

import sun.org.mozilla.javascript.internal.xml.XMLLib;

/**
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 * Created by kevin on 2016/2/26.
 */
public class L007_ReverseInteger {
    public int reverse(int x) {
        /*int result = 0;
        while(x != 0)
        {
            int newResult = result*10 + x%10;
            if((newResult - x%10)/10 != result)
                return 0;
            x = x/10;
            result = newResult;
        }
        return result;*/

        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }
        String str = String.valueOf(x);
        char[] ch = str.toCharArray();
        char tmp;
        int len = ch.length;
        for (int i = 0; i < len/2; i++) {
            tmp = ch[i];
            ch[i] = ch[len - 1 - i];
            ch[len - 1 - i] = tmp;
        }
        String res = String.valueOf(ch);
        int result;
        try {
            result = Integer.parseInt(res);
        } catch (Exception e) {
            result = 0;
        }
        if (flag) {
            result = -result;
        }
        return result;
    }
}
