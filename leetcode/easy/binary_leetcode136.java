package leetcode.easy;

import java.util.HashMap;

public class binary_leetcode136 {
    // hashmap存储频次求解，时间复杂度On，空间复杂度On
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashmap.containsKey(nums[i])){
                hashmap.put(nums[i], hashmap.get(nums[i])+1);
            }else{
                hashmap.put(nums[i], 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(hashmap.get(nums[i]) == 1) return nums[i];
        }
        return -1;
    }
}
