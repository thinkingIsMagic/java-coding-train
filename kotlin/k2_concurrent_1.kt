object ConcurrentList{
    private val list: MutableList<Int> = mutableListOf<Int>();
    private val lock = Any();


    fun add(a: Int){
        synchronized(lock) { list.add(a) }
    }

    fun get(index: Int): Int{
        synchronized(lock) { return list.get(index) }
    }
}