package leetcode.easy;

import java.util.HashMap;

public class Map_leetcode387 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.print("res: " + firstUniqChar(s));
    }

    public static int firstUniqChar(String s){
        // 泛型里不能写基本类型，要写包装类（引用类型），原因是泛型的类型擦出，只支持引用类型
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 1、存储频次
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int value = map.get(c);
                map.put(c, value+1);
            }else{
                map.put(c, 1);
            }
        }

        // 2、找到频次为1的元素
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int value = map.get(c);
            if(value==1){
                return i;
            }
        }
        return -1;
    }
}
