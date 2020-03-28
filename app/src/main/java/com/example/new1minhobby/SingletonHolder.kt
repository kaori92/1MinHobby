package com.example.new1minhobby

open class SingletonHolder<out T: Any, in A, in B, in C>(creator: (A, B, C) -> T) {
    private var creator: ((A, B, C) -> T)? = creator
    @Volatile private var instance: T? = null

    fun getInstance(arg: A, arg2: B, arg3: C): T {
        val checkInstance = instance
        if (checkInstance != null) {
            return checkInstance
        }

        return synchronized(this) {
            val checkInstanceAgain = instance
            if (checkInstanceAgain != null) {
                checkInstanceAgain
            } else {
                val created = creator!!(arg, arg2, arg3)
                instance = created
                creator = null
                created
            }
        }
    }
}