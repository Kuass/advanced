package kr.kua.proxy.trace.logtrace

import kr.kua.proxy.trace.TraceStatus

interface LogTrace {

    fun begin(message: String): TraceStatus
    fun end(status: TraceStatus)
    fun exception(status: TraceStatus?, e: Exception)
}