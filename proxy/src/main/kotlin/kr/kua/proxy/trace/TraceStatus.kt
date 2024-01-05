package kr.kua.demo_first.trace

class TraceStatus {

    private var traceId: TraceId
    private var startTimeMs: Long = 0
    private var message: String

    constructor(traceId: TraceId, startTimeMs: Long, message: String) {
        this.traceId = traceId
        this.startTimeMs = startTimeMs
        this.message = message
    }

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