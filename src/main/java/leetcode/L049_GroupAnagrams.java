package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 * <p/>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p/>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 * <p/>
 * Created by kevin on 2016/3/16.
 */
public class L049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Arrays.sort(strs);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = String.valueOf(ch);
            if (!map.containsKey(str)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
                map.put(str, list);
            } else {
                ArrayList<String> list = map.get(str);
                list.add(strs[i]);
            }
        }
        return lists;
    }
}
