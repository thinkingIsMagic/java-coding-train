package leetcode.easy;

public class binary_leetcode191 {

    // 先转成二进制字符串、再求1的个数
    // 时间复杂度O(n)，空间复杂度O(n);
    public int hammingWeight(int n) {
        String n_str = Integer.toBinaryString(n);
        int count = 0;
        for(int i=0; i<n_str.length(); i++){
            char c = n_str.charAt(i);
            if(c=='1') count++;
        }
        return count;
    }
}