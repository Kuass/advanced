package kr.kua.demo_first.app.v5

import kr.kua.demo_first.trace.callback.TraceTemplate
import kr.kua.demo_first.trace.logtrace.LogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV5(
    private val orderService: OrderServiceV5,
    trace: LogTrace
) {
    private var template: TraceTemplate = TraceTemplate(trace)

    @GetMapping("/v5/request")
    fun request(itemId: String) =
        template.execute("OrderController.request()") {
            orderService.orderItem(itemId)
            "ok"
        }
}