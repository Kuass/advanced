package hello.advanced.trace.logtrace

import hello.advanced.trace.TraceId
import hello.advanced.trace.TraceStatus
import lombok.extern.slf4j.Slf4j

@Slf4j
class FieldLogTrace : LogTrace {

    private val START_PREFIX = "-->"
    private val COMPLETE_PREFIX = "<--"
    private val EX_PREFIX = "<X-"
    private val logger = org.slf4j.LoggerFactory.getLogger(this::class.java)

    private var traceIdHolder: TraceId? = null // traceId 동기화, 동시성 이슈 발생

    override fun begin(message: String): TraceStatus {
        syncTraceId()
        val traceId: TraceId = traceIdHolder!!
        val startTimeMs = System.currentTimeMillis()
        logger.info("[{}] {} {}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message)
        return TraceStatus(traceId, startTimeMs, message)
    }

    private fun syncTraceId() {
        traceIdHolder = if (traceIdHolder == null) {
            TraceId()
        } else {
            traceIdHolder!!.createNextId()
        }
    }

    override fun end(status: TraceStatus) {
        complete(status, null)
    }

    override fun exception(status: TraceStatus?, e: Exception) {
        if (status != null) {
            complete(status, e)
        }
    }

    private fun complete(status: TraceStatus, e: java.lang.Exception?) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs = stopTimeMs - status.getStartTimeMs()
        val traceId = status.getTraceId()
        if (e == null) {
            logger.info(
                "[{}] {}{} time={}ms", traceId.getId(),
                addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),
                resultTimeMs
            )
        } else {
            logger.info(
                "[{}] {}{} time={}ms ex={}", traceId.getId(),
                addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
                e.toString()
            )
        }

        releaseTraceId()
    }

    private fun releaseTraceId() {
        if (traceIdHolder == null || traceIdHolder!!.isFirstLevel()) {
            traceIdHolder = null
        } else {
            traceIdHolder = traceIdHolder!!.createPreviousId()
        }
    }

    private fun addSpace(prefix: String, level: Int): String? {
        val sb = StringBuilder()
        for (i in 0 until level) {
            sb.append(if (i == level - 1) "|$prefix" else "| ")
        }
        return sb.toString()
    }

}