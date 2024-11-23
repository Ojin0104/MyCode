import java.util.*;
class LRUCache {
    LinkedHashMap<Integer,Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer,Integer>();
        
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
       if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
       }
        if(map.size()==this.capacity&&!map.containsKey(key)){
            int firstKey = map.keySet().iterator().next();
            map.remove(firstKey);
        }
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */