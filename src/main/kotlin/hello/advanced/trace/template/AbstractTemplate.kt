package hello.advanced.trace.template

import hello.advanced.trace.TraceStatus
import hello.advanced.trace.logtrace.LogTrace


abstract class AbstractTemplate<T>(trace: LogTrace) {

    private var trace: LogTrace

    init {
        this.trace = trace
    }

    public fun execute(message: String): T {
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