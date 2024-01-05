package kr.kua.demo_first.app.v4

import kr.kua.demo_first.app.v5.OrderRepositoryV5
import kr.kua.demo_first.trace.logtrace.LogTrace
import kr.kua.demo_first.trace.template.AbstractTemplate
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderServiceV4(
    val orderRepository: OrderRepositoryV5,
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