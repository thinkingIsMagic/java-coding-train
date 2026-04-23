package leetcode.medium;

import java.util.HashMap;

public class Window_leetcode76 {

    // 双map + valid计数: right扩张凑齐t所有字符种类后,left循环右移收缩到刚好仍满足,记录最短
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        // t需要的字符频次
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else {
                need.put(c, 1);
            }
        }

        // 已满足需求的字符种类数 (频次达标即+1)
        int valid = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 扩张: 入窗口
            if (need.containsKey(c)) {
                if (window.containsKey(c)) {
                    window.put(c, window.get(c) + 1);
                } else {
                    window.put(c, 1);
                }
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 收缩: 只要窗口仍覆盖t, 就尝试右移left
            while (valid == need.size()) {
                int curLen = right - left + 1;
                if (curLen < minLen) {
                    minStart = left;
                    minLen = curLen;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    // 频次刚从达标跌到不达标, 种类数-1
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}