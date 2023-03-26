package hello.advanced.app.v1

import hello.advanced.trace.TraceStatus
import hello.advanced.trace.hellotrace.HelloTraceV1
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderServiceV1(
    val orderRepository: OrderRepositoryV1,
    val trace: HelloTraceV1
) {

    fun orderItem(itemId: String) {


        val status: TraceStatus = trace.begin("OrderServiceV1.orderItem()")
        try {
            orderRepository.save(itemId)
            trace.end(status)
        }catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }

}