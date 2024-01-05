package kr.kua.demo_first.trace.hellotrace

import kr.kua.demo_first.trace.TraceId
import kr.kua.demo_first.trace.TraceStatus
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Component

@Slf4j
@Component
class HelloTraceV1 {

    private val START_PREFIX = "-->"
    private val COMPLETE_PREFIX = "<--"
    private val EX_PREFIX = "<X-"
    private val logger = org.slf4j.LoggerFactory.getLogger(HelloTraceV1::class.java)

    fun begin(message: String): TraceStatus {
        val traceId = TraceId()
        val startTimeMs = System.currentTimeMillis()
        logger.info("[{}] {} {}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message)
        return TraceStatus(traceId, startTimeMs, message)
    }

    fun end(status: TraceStatus) {
        complete(status, null)
    }

    fun exception(status: TraceStatus, e: Exception) {
        complete(status, e)
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
    }

    private fun addSpace(prefix: String, level: Int): String {
        val sb = StringBuilder()
        for (i in 0 until level) {
            sb.append(if (i == level - 1) "|$prefix" else "| ")
        }
        return sb.toString()
    }

}