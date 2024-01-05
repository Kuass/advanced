package kr.kua.proxy.trace.template

import kr.kua.proxy.trace.TraceStatus
import kr.kua.proxy.trace.logtrace.LogTrace


abstract class AbstractTemplate<T>(private var trace: LogTrace) {

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