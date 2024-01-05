package kr.kua.demo_first.trace.callback

import kr.kua.demo_first.trace.TraceStatus
import kr.kua.demo_first.trace.logtrace.LogTrace


class TraceTemplate(private val trace: LogTrace) {

    fun <T> execute(message: String, callback: TraceCallback<T>): T {
        var status: TraceStatus? = null
        return try {
            status = trace.begin(message)
            //로직 호출
            val result = callback.call()
            trace.end(status)
            result
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }

}