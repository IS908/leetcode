package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kevin on 2017-08-26 16:06.
 */
public class L451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        List<Character>[] lists = new List[chs.length + 1];
        for (char ch : map.keySet()) {
            int frequency = map.get(ch);
            if (lists[frequency] == null) {
                lists[frequency] = new ArrayList<>();
            }
            lists[frequency].add(ch);
        }
        int j = 0;
        for (int i = chs.length; i >= 0; --i) {
            List<Character> lst = lists[i];
            if (lst == null || lst.size() < 1) continue;
            for (char ch : lst) {
                for (int m = 0; m < i; m++, j++) {
                    chs[j] = ch;
                }
            }
        }
        return String.valueOf(chs);
    }

    public static void main(String[] args) {
        String str = "abcccdda";
        L451_SortCharactersByFrequency sortCharactersByFrequency = new L451_SortCharactersByFrequency();
        String res = sortCharactersByFrequency.frequencySort(str);
        System.out.println(res);
    }
}
