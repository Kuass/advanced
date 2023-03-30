package hello.advanced.app.v4

import hello.advanced.trace.TraceStatus
import hello.advanced.trace.logtrace.LogTrace
import hello.advanced.trace.template.AbstractTemplate
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderServiceV4(
    val orderRepository: OrderRepositoryV4,
    val trace: LogTrace
) {

    fun orderItem(itemId: String) {
        val template: AbstractTemplate<Unit> = object : AbstractTemplate<Unit>(trace) {
            override fun call() {
                orderRepository.save(itemId)
                return
            }
        }
        return template.execute("OrderServiceV4.orderItem()")
    }

}