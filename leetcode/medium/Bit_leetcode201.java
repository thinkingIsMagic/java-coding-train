package leetcode.medium;

public class Bit_leetcode201 {
    /**
    思路：公共前缀 / 位运算：左移/右移
    具体操作：left 和 right 同时右移直到相等（找到公共前缀），再左移回去。
    原因：low→high 之间低位会经历所有 0/1 变化，AND 后全归 0，只有公共前缀保留。
    例：[10,13] → 1010 & 1011 & 1100 & 1101 = 1000
    */
    public int rangeBitwiseAnd(int left, int right) {
        int move = 0;
        while(left!=right){
            left = left>>1;
            right = right>>1;
            move++;
        }
        return left<<=move;
    }
}
