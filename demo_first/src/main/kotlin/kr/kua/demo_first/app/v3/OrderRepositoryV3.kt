package kr.kua.demo_first.app.v3

import kr.kua.demo_first.trace.TraceStatus
import kr.kua.demo_first.trace.logtrace.LogTrace
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class OrderRepositoryV3(
    val trace: LogTrace
) {

    fun save(itemId: String) {
        val status: TraceStatus = trace.begin("OrderRepositoryV3.save()")

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