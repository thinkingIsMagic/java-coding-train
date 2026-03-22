package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class Stack_leetcode739 {
    // 算法模拟：
    // 输入: [73,74,75,71,69,72,76,73]
    // 处理过程：
    // i=0 → 栈空入栈 [0]
    // i=1 → 74>73 → 弹出0，ans[0]=1 → 入栈1 [1]
    // i=2 → 75>74 → 弹出1，ans[1]=1 → 入栈2 [2]
    // i=3 → 71<75 → 入栈3 [2,3]
    // i=4 → 69<71 → 入栈4 [2,3,4]
    // i=5 → 72>69 → 弹出4，ans[4]=1 → 72>71 → 弹出3，ans[3]=2 → 入栈5 [2,5]
    // i=6 → 76>72 → 弹出5，ans[5]=1 → 76>75 → 弹出2，ans[2]=4 → 入栈6 [6]
    // i=7 → 73<76 → 入栈7 [6,7]
    // 最终结果: [1,1,4,2,1,1,0,0]

    // 单调栈：要求从 栈底 到 栈顶 的元素是单调递增（或者单调递减）
    // 单调递减栈：只有比栈顶元素小的元素才能直接进栈，否则需要先将栈中比当前元素大的元素出栈，再将当前元素入栈

    // 思路：用单调递减栈，存下标，从左到右遍历，一旦遇到更大的温度，就不断弹栈并计算天数差。
    // 核心：每个元素都在等一个比自己大的人来"收走"自己
    // 阶段1：我比栈顶大？那栈顶等到我了，结算！；阶段2：我入栈，开始等未来某个更大的来收我
    // 时间复杂度 O(n)、空间复杂度O(n)

    // 1、关键信息：1、输入：数组、2、求什么：下一个更大  3、有没有关键约束：无
    // 2、下一个更大 -> 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        
        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i-index;
            }
            stack.push(i);
        }
        return res;
    }
}
