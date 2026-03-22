package leetcode.easy;

import java.util.HashMap;

class Map_leetcode1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int diff = target-nums[i];
            if(map.containsKey(diff)){
                return new int[]{i, map.get(diff)};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}