import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class demo4 {
    public int calculateSequence (int M, int N) {
        // write code here
        if(N<=M) return N;
        int window = M;
        int[] nums = new int[N];
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<M; i++){
            queue.offer(i+1);
        }
        for(int i=M+1; i<=N; i++){
            
            if(containsSameItem(queue)){
                nums[i-1] = getMax(queue) + getMin(queue);
            }else{
                nums[i-1] = getMax(queue) - getMin(queue);
            }
            //TODO 这里错了 num[i-1]
            queue.offer(i);
            queue.poll();
        }
        return nums[N-1];
    }

    public boolean containsSameItem(Deque<Integer> queue){
        HashSet<Integer> set = new HashSet<>();
        queue.forEach((num)->{
            set.add(num);
        });
        return set.size() == queue.size();
    }

    public int getMax(Deque<Integer> queue){
        int max = -1;
        queue.forEach(( num)->{
            if(num>max){
                max = num;
            }
        });
        return max;
    }

    public int getMin(Deque<Integer> queue){
        int min = 100;
        queue.forEach(( num)->{
            if(num<min){
                min = num;
            }
        });
        return min;
    }
}
