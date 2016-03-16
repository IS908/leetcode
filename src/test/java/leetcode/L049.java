package leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by kevin on 2016/3/16.
 */
public class L049 {
    @Test
    public void test() {
        L049_GroupAnagrams groupAnagrams = new L049_GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String str: list) {
                System.out.print(str + ", ");
            }
            System.out.println();
        }
    }
}
