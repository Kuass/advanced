package kr.kua.demo_first.trace

import java.util.*

class TraceId {
    private var id: String
    private var level: Int

    constructor() {
        id = createId()
        level = 0
    }

    private constructor(id: String, level: Int) {
        this.id = id
        this.level = level
    }

    private fun createId(): String {
        return UUID.randomUUID().toString().substring(0, 8)
    }

    fun createNextId(): TraceId {
        return TraceId(id, level + 1)
    }

    fun createPreviousId(): TraceId {
        return TraceId(id, level - 1)
    }

    fun isFirstLevel(): Boolean {
        return level == 0
    }

    fun getId(): String {
        return id
    }

    fun getLevel(): Int {
        return level
    }
}

//class TraceId {
//    var id: String
//        private set
//    var level: Int
//        private set
//
//    constructor() {
//        id = createId()
//        level = 0
//    }
//
//    private constructor(id: String, level: Int) {
//        this.id = id
//        this.level = level
//    }
//
//    private fun createId(): String {
//        return UUID.randomUUID().toString().substring(0, 8)
//    }
//
//    fun createNextId(): TraceId {
//        return TraceId(id, level + 1)
//    }
//
//    fun createPreviousId(): TraceId {
//        return TraceId(id, level - 1)
//    }
//
//    val isFirstLevel: Boolean
//        get() = level == 0
//}