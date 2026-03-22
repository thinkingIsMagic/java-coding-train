package leetcode.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Stack_leetcode20 {
    public static Boolean isValid(String s){
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        // Deque = Double Ended Queue，双端队列，接口
        Deque<Character> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(stack.size()==0){
                stack.push(c);
                continue;
            }
            char peek = stack.peek();
            if(map.get(peek)==c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.print(isValid(s));
    }
}
