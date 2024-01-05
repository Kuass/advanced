package kr.kua.demo_first.app.v4

import kr.kua.demo_first.app.v5.OrderServiceV5
import kr.kua.demo_first.trace.logtrace.LogTrace
import kr.kua.demo_first.trace.template.AbstractTemplate
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class OrderControllerV4(
    val orderService: OrderServiceV5,
    val trace: LogTrace
) {

    @GetMapping("/v4/request")
    fun request(itemId: String): String {
        val template: AbstractTemplate<String> = object : AbstractTemplate<String>(trace) {
            override fun call(): String {
                orderService.orderItem(itemId)
                return "ok"
            }
        }
        return template.execute("OrderControllerV4.request()")
    }

}