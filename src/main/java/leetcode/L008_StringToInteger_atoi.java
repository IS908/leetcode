package leetcode;

/**
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 * Created by kevin on 2016/2/26.
 */
public class L008_StringToInteger_atoi {
    public int myAtoi(String str) {
        char[] ch = str.trim().toCharArray();
        boolean flag = false, zero = true;
        int result = 0, tmp = 0;
        for (int i = 0; i < ch.length; i++) {
            if (i == 0) {
                switch (ch[0]) {
                    case '-':
                        flag = true;
                        continue;
                    case '+':
                        flag = false;
                        continue;
                    case '0':
                        continue;
                }
            }
            if (zero && ch[i] == '0') continue;
            else zero = false;
            if (ch[i] > '9' || ch[i] < '0') break;
            tmp = ch[i] - '0';
            if(result>Integer.MAX_VALUE/10||result==Integer.MAX_VALUE/10&&Integer.MAX_VALUE %10 < tmp)
                return flag?Integer.MIN_VALUE:Integer.MAX_VALUE;
            result = result * 10 + tmp;
        }
        if (flag) {
            result = -result;
        }
        return result;
    }
}
