package kr.kua.demo_first.trace.template

import kr.kua.demo_first.trace.TraceStatus
import kr.kua.demo_first.trace.logtrace.LogTrace


abstract class AbstractTemplate<T>(trace: LogTrace) {

    private var trace: LogTrace

    init {
        this.trace = trace
    }

    fun execute(message: String): T {
        var status: TraceStatus? = null
        try {
            status = trace.begin(message)
            val result = call()

            trace.end(status)
            return result
        } catch (ex: Exception) {
            trace.exception(status, ex)
            throw ex
        }
    }

    protected abstract fun call(): T

}