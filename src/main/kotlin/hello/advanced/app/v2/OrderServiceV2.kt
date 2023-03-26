package hello.advanced.app.v2

import hello.advanced.trace.TraceId
import hello.advanced.trace.TraceStatus
import hello.advanced.trace.hellotrace.HelloTraceV2
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderServiceV2(
    val orderRepository: OrderRepositoryV2,
    val trace: HelloTraceV2
) {

    fun orderItem(traceId: TraceId, itemId: String) {
        val status: TraceStatus = trace.beginSync(traceId, "OrderServiceV2.orderItem()")
        try {
            orderRepository.save(status.getTraceId(), itemId)
            trace.end(status)
        }catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }

}