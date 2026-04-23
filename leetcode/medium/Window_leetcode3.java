package leetcode.medium;

import java.util.HashMap;

public class Window_leetcode3 {
    // 思路：滑动窗口、map
    // 时间复杂度：On 数组只遍历一遍(每个字符最多被访问两次)
    // 空间复杂度：On，最差所有元素都不同，放到map中

    // 输入：字符串、求什么：最长子串长度、约束：子串字符无重复
    // 连续子串、最长 -> 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        // 存字符最后一次出现的index
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;

        int left=0;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c) && map.get(c)>=left){
                left = map.get(c) + 1;
            }

            max = Math.max(right-left+1, max);
            map.put(c, right);
        }
        return max;
    }
    // "pwwkew"
    // [0,0] [0,1] [0,2], [2,2], [2,3], [2,4], [2,5], [3,5]

    // 滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max=0;

        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            // 当前字符在区间内重复，需要更新左边界
            if(map.containsKey(c) && map.get(c)>=left){
                left = map.get(c)+1;
            }
            
            max = Math.max(max, right-left+1);
            map.put(c, right);
        }
        return max;
    }
}
