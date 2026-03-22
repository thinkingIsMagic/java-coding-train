package practice_java;

public class p2_concurrent_2 {
    // 题目：3个线程，一个打A、一个打B、一个打C、输出五次：ABCABC...
    // 思路：synchroized、wait/notify
    public static void main(String[] args) {
        new Thread(()->{printABC("A", 0);},"threadA").start();
        new Thread(()->{printABC("B", 1);},"threadB").start();
        new Thread(()->{printABC("C", 2);},"threadC").start();
    }

    private static Object lock = new Object();
    // 0:A 1:B 2:C
    private static int state = 0;
    private static int MAX = 5;

    public static void printABC(String s, int tag){
        for(int i=0; i<MAX; i++){
            synchronized(lock){
                while(tag!=state%3){
                    try {
                        lock.wait();
                    } catch (Exception e) {}
                }
                System.out.print(s);
                state++;
                lock.notifyAll();
            }
        }
    }
}
