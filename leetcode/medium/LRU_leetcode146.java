package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRU_leetcode146 {

    /**
     * 思路：map + 双向链表，本质是用map存，用双向链表维护key插入的顺序，头部是最久远（淘汰），尾部是最新
    （1）get：先判断key是否存在、不存在直接返回-1，存在把节点移动到尾部（先删除、再添加）
    （2）put：1、key存在时：直接移动到尾部；
            2、key不存在时：如果容量没满、存入map、添加到尾部；满了、先移除头部节点（最久远元素）、再插入到尾部
     */
    class LRUCache {
        private HashMap<Integer, Integer> map;
        private int capacity;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<>();
            this.capacity = capacity;
        }
        
        public int get(int key) {
            if(map.containsKey(key)){
                return -1;
            }else{
                moveToEnd(key);
                return map.get(key);
            }
        }
        
        public void put(int key, int value) {
            if(map.containsKey(key)){
                moveToEnd(key);
            }else{
                if(map.size()<capacity){
                    map.put(key, value);
                }else{
                    int startKey = map.keySet().iterator().next();
                    map.remove(startKey);
                    map.put(key, value);
                }
            }
        }

        public void moveToEnd(int key){
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
        }
    }
}
