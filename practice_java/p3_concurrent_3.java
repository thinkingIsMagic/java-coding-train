package practice_java;

import java.util.ArrayList;
import java.util.List;

public class p3_concurrent_3 {
    
    
    // 线程安全集合(List)
    public static class ConcurrentList<E>{
        private final List<E> list = new ArrayList<>();
        private final Object lock = new Object();

        // java会自动无参的构造器，不用写

        public void add(E a){
            synchronized(lock){
                list.add(a);
            }
        }

        public E get(int index){
            synchronized(lock){
                return list.get(index);
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentList<Integer> list = new ConcurrentList<>();
        new Thread(()->{
            for(int i=0; i<100;i++){
                list.add(0);
                System.out.println(0);
            }
        },"thread_1").start();;
        new Thread(()->{
            for(int i=0; i<100;i++){
                list.add(1);
                System.out.println(1);
            }
        }, "thread_2").start();;

    }
}


