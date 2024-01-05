package kr.kua.proxy.trace

class TraceStatus(private var traceId: TraceId, private var startTimeMs: Long, private var message: String) {

    fun getStartTimeMs(): Long {
        return startTimeMs
    }

    fun getMessage(): String {
        return message
    }

    fun getTraceId(): TraceId {
        return traceId
    }

}