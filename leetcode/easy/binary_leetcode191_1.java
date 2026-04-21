package leetcode.easy;

public class binary_leetcode191_1 {

    // 思路：n&n-1，可以消除最低位的1
    // 时间复杂度O(n)，空间复杂度O(1);
    public int hammingWeight(int n) {
        int count = 0;
        while(n>0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}