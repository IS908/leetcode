package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: You are given a string, s, and a list of words, words, that are all of the same length.<br/>
 * Find all starting indices of substring(s) in s that is a concatenation of each word <br/>
 * in words exactly once and without any intervening characters.<br/>
 * @Auther: kun
 * @Date: 2019-06-25 09:37
 */
public class L030_SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return list;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int step = words[0].length();
        int k = step * words.length;
        int n = s.length();

        for (int i = 0; i < n - k + 1; i++) {
            Map<String, Integer> proto = new HashMap<>(wordMap);
            int counter = proto.size();
            for (int j = i; j < i + k; j += step) {
                String tmp = s.substring(j, j + step);
                if (!proto.containsKey(tmp)) {
                    break;
                }
                Integer count = proto.get(tmp);
                if (count == 1) {
                    counter--;
                }
                proto.put(tmp, count - 1);
            }
            if (counter == 0) {
                list.add(i);
            }
        }

        return list;
    }

}
