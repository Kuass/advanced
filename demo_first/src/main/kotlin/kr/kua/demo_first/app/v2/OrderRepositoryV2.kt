package kr.kua.demo_first.app.v2

import kr.kua.demo_first.trace.TraceId
import kr.kua.demo_first.trace.TraceStatus
import kr.kua.demo_first.trace.hellotrace.HelloTraceV2
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class OrderRepositoryV2(
    val trace: HelloTraceV2
) {

    fun save(traceId: TraceId, itemId: String) {
        val status: TraceStatus = trace.beginSync(traceId, "OrderRepositoryV2.save()")

        try {
            if (itemId == "ex") {
                throw IllegalStateException("예외 발생!")
            }
            sleep(1000)

            trace.end(status)
        }catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }

    }

    private fun sleep(millis: Int) {
        Thread.sleep(millis.toLong())
    }
}