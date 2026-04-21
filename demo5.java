import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class demo5 {

    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println(calMN(5,10));
    }

    public static int calMN(int M, int N){
        if(N<=M) return N;

        int[] nums = new int[N];
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<M; i++){
            nums[i] = i+1;
            queue.offer(nums[i]);
        }

        for(int i=M+1; i<=N; i++){

            int max = getMax(queue);
            int min = getMin(queue);
            if(containsSameItem(queue)){
                nums[i-1] = max + min;
            }else{
                nums[i-1] = max -min;
            }
            queue.poll();
            queue.offer(nums[i-1]);
        }
        return nums[N-1];
    }

    public static boolean containsSameItem(Deque<Integer> queue){
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : queue) {
            set.add(num);
        }
        return set.size() != queue.size();
    }

    public static int getMax(Deque<Integer> queue){
        int max = -1;
        for (Integer num : queue) {
            if(num>max){
                max = num;
            }
        }
        return max;
    }

    public static int getMin(Deque<Integer> queue){
        int min = 100;
        for (Integer num : queue) {
            if(num<min){
                min = num;
            }
        }
        return min;
    }

}
