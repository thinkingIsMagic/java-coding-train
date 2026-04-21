// 1、普通单例（线程安全）
object Singleton0{}

// 2、懒汉式
// 什么时候必须写 constructor 关键字？ 
// 当你要给它加修饰符（private等注解）的时候，就不能省略了，必须写出来
class Singleton1 private constructor(){
    companion object{
        @Volatile
        private var instance: Singleton1? = null;

        @Synchronized
        fun getInstance(): Singleton1{
            if(instance==null){
                instance = Singleton1()
            }
            return instance!!;
        }
    }
}

// 2、双重检锁
class Singleton2 private constructor(){

    companion object{
        private var instance: Singleton2? =  null

        fun getInstance(): Singleton2{
            if(instance==null){
                synchronized(this) { 
                    if(instance==null){
                        instance = Singleton2();
                    }
                }
            }
            return instance!!;
        }
    }
}