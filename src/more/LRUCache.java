package more;

import java.util.LinkedHashMap;
import java.util.Map;
//来自：https://www.cnblogs.com/DarrenChan/p/8744354.html
class LRUCache4{
    int capacity;
    LinkedHashMap<Integer, Integer> map;
    public LRUCache4(int capacity){
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }
    public int get(int key){
        if (map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }else {
            return -1;
        }
    }
    public void put(int key, int value){
        if (map.containsValue(key)){
            map.remove(key);
        }
        if (map.size()>=capacity){
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}
public class LRUCache {
    public static void main(String[] args) {
//        Map<String, Integer> seqMap = new LinkedHashMap<>();
//        seqMap.put("c", 100);
//        seqMap.put("d",2);
//        seqMap.put("a", 3);
//        seqMap.put("b", 4);
////        seqMap.remove("d");
//        for (Map.Entry<String, Integer> entry:seqMap.entrySet()){
//            System.out.println(entry.getKey()+","+entry.getValue());
//        }

        LRUCache4 lruCache4 = new LRUCache4(4);
        lruCache4.put(1, 10);
        System.out.println(lruCache4.get(2));
        lruCache4.put(2, 20);
        lruCache4.put(3, 30);
        System.out.println(lruCache4.get(1));
        System.out.println(lruCache4.get(2));
        for (Map.Entry<Integer,Integer> entry:lruCache4.map.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
