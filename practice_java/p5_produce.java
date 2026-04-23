package practice_java;

import java.util.Deque;
import java.util.LinkedList;

public class p5_produce{
    // 是否要写成静态变量标准：这个变量是“属于类本身的一份”，还是“每个对象各有一份”
    private static final int cap = 5;
    private final Deque<Integer> queue = new LinkedList<>();
    private final Object lock = new Object();

    // InterruptedException: 线程中断异常，常见 lock.wait方法
    public void produce(int value) throws InterruptedException{
        synchronized(lock){
            // 队列满了，停止生产 / 队列为空，停止消费
            while(queue.size()>=cap){
                lock.wait();
            }
            queue.offer(value);
            lock.notifyAll();
            // System.out.println("produce: " + value + ", size=" + queue.size());
        }
    }

    public int consume() throws InterruptedException{
        synchronized(lock){
            while(queue.size()<=0){
                lock.wait();
            }
            int value = queue.poll();
            lock.notifyAll();
            // System.out.println("consume: " + value + ", size=" + queue.size());
            return value;
        }
    }

    public static void main(String[] args) {
        p5_produce pc = new p5_produce();

        new Thread(()->{
            for(int i=0; i<100; i++){
                try{
                    pc.produce(i);
                }catch(Exception e){}
            }
        },"produce-thread").start();

        new Thread(()->{
            while(true){
                try {
                    pc.consume();
                } catch (Exception e) {}
            }
        },"consume-thread").start();
    }

}
