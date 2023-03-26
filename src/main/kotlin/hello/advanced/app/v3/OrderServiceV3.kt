package hello.advanced.app.v3

import hello.advanced.trace.TraceId
import hello.advanced.trace.TraceStatus
import hello.advanced.trace.logtrace.LogTrace
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderServiceV3(
    val orderRepository: OrderRepositoryV3,
    val trace: LogTrace
) {

    fun orderItem(itemId: String) {
        val status: TraceStatus = trace.begin("OrderServiceV3.orderItem()")
        try {
            orderRepository.save(itemId)
            trace.end(status)
        }catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }

}