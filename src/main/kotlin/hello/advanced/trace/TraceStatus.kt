package hello.advanced.trace

class TraceStatus {

    private var traceId: TraceId
    private var startTimeMs: Long = 0
    private var message: String

    constructor(traceId: TraceId, startTimeMs: Long, message: String) {
        this.traceId = traceId
        this.startTimeMs = startTimeMs
        this.message = message
    }

    public fun getStartTimeMs(): Long {
        return startTimeMs
    }

    public fun getMessage(): String {
        return message
    }

    public fun getTraceId(): TraceId {
        return traceId
    }

}