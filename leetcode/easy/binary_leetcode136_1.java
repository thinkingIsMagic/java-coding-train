package leetcode.easy;

import java.util.HashMap;

public class binary_leetcode136_1 {
    // 除了某个元素只出现一次以外，其余每个元素均出现两次 -> 异或性质
    // 时间复杂度O(n)、空间复杂度O(1)
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
