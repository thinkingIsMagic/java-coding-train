package practice_java;

// 单例
public class p4_single {


    // 1、饿汉式
    public static class SingleClass{
        private static final SingleClass instance = new SingleClass();

        private SingleClass(){}
    
        public static SingleClass getInstance(){
            return instance;
        }
    }

    // 2、懒汉式
    public static class SingleClass2{
        private static SingleClass2 instance;

        private SingleClass2(){}

        public static synchronized SingleClass2 getInstance(){
            if(instance==null){
                instance = new SingleClass2();
            }
            return instance;
        }
    }

    // 3、双重检锁
    public static class SingleClass3{
        private static volatile SingleClass3 instance;
        private static final Object lock = new Object();

        private SingleClass3(){}

        public static SingleClass3 getInstance(){
            if(instance==null){
                synchronized(lock){
                    if(instance==null){
                        instance = new SingleClass3();
                    }
                }
            }
            return instance;
        }
    }

    // 4、静态内部类
    public static class SingleClass4{

        private SingleClass4(){}

        public static SingleClass4 getInstance(){
            return SingleClass4Holder.instance;
        }

        private static class SingleClass4Holder{
            private static final SingleClass4 instance = new SingleClass4();
        }

    } 
    
}
