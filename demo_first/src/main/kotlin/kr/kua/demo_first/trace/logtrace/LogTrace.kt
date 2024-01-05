package kr.kua.demo_first.trace.logtrace

import kr.kua.demo_first.trace.TraceStatus

interface LogTrace {

    fun begin(message: String): TraceStatus
    fun end(status: TraceStatus)
    fun exception(status: TraceStatus?, e: Exception)
}