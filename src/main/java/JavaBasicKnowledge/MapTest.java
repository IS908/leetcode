package JavaBasicKnowledge;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by kevin on 2016/3/15.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(32);
        map.put("1", "1");
        map.put(null, "abc");       // 正常执行，hashMap对key为null的键直接映射到了hash值为0
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put(null, "1");   // 抛出异常 hashtable没有对key值为null做相关处理
    }
}
