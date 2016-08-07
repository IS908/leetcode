package NowCoder.NetEase;

import java.util.*;

/**
 * Created by kevin on 16-8-2.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (in.hasNext()) {
            String str = in.next().trim();
            list.add(str);
        }

        HashMap<Integer, Integer> map = count(list);
        HashMap<Integer, List<Integer>> result = reverseKV(map);

        List<Integer> list1 = new ArrayList<>(result.keySet());
        Collections.sort(list1);

        for (int i = list1.size() - 1; i >= 0; i--) {
            int key = list1.get(i);
            List<Integer> l = result.get(key);
            Collections.sort(l);
            Collections.reverse(l);
            for (Integer tmp : l) {
                System.out.println(tmp);
            }
        }

    }

    private static HashMap<Integer, List<Integer>> reverseKV(HashMap<Integer, Integer> map) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = hashMap.get(entry.getValue());
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(entry.getKey());
            hashMap.put(entry.getValue(), list);
        }
        return hashMap;
    }

    private static HashMap<Integer, Integer> count(List<String> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String str : list) {
            String[] strs = str.split("|");
            int country = Integer.parseInt(strs[strs.length - 1]);
            Integer cur = map.get(country);
            if (cur == null) {
                cur = 0;
            }
            map.put(country, cur + 1);
        }
        return map;
    }
}
