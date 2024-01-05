package kr.kua.proxy.trace.callback

fun interface TraceCallback<T> {
    fun call(): T
}