package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class Stack_leetcode155 {
    // 思路：栈，额外维护一个存储当前高度最小值的栈
    // push: 入栈、最小栈里比较出小值再入栈
    // pop: 正常出栈
    // 时间复杂度 O(1),空间复杂度O(n)
    class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public MinStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
        }
        
        public void push(int val) {
            this.stack.push(val);

            if(this.minStack.size()==0){
                this.minStack.push(val);
            }else{
                int min = Math.min(val, this.getMin());
                this.minStack.push(min);
            }
        }
        
        public void pop() {
            this.stack.pop();
            this.minStack.pop();
        }
        
        public int top() {
            return this.stack.peek();
        }
        
        public int getMin() {
            return this.minStack.peek();
        }
    }
}
