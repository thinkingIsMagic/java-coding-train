package practice_java;

// 两个线程交替打印（1-100 奇偶数）
// 思路：synchronized、wait/notify
// 实现：共用一把锁 + 一个计数器，打完一个数后 notify 唤醒对方，wait 挂起自己，实现一唤一等交替执行
// 不需要加 volatile：因为 synchronized 已经同时保证了「可见性 + 原子性 + 有序性」。
public class p1_concurrent_1 {
    private static int num = 1;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{printNum();},"thread1").start();
        new Thread(()->{printNum();},"thread2").start();
    }

    public static void printNum(){
        while(true){
            synchronized(lock){
                // 1、打印
                if(num>100) break;
                System.out.print(num);
                // System.out.print(Thread.currentThread().getName());
                num++;

                // 2、唤醒其他线程
                lock.notifyAll();
                // 3、自己挂起、让出cpu
                try{
                    if(num<=100) lock.wait();
                }catch(Exception e){}
                
            }
        }
    }
}
