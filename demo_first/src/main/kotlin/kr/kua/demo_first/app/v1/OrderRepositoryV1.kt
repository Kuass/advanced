package kr.kua.demo_first.app.v1

import kr.kua.demo_first.trace.TraceStatus
import kr.kua.demo_first.trace.hellotrace.HelloTraceV1
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class OrderRepositoryV1(
    val trace: HelloTraceV1
) {

    fun save(itemId: String) {

        val status: TraceStatus = trace.begin("OrderRepositoryV1.save()")
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