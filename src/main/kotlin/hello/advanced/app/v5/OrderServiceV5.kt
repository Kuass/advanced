package hello.advanced.app.v5

import hello.advanced.trace.callback.TraceTemplate
import hello.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV5(
    private val orderRepository: OrderRepositoryV5,
    trace: LogTrace
) {
    private var template: TraceTemplate = TraceTemplate(trace)

    fun orderItem(itemId: String) {
        template.execute("OrderServiceV5.orderItem()") {
            orderRepository.save(itemId)
            "ok"
        }
    }
}