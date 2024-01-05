package kr.kua.demo_first.trace.callback

fun interface TraceCallback<T> {
    fun call(): T
}