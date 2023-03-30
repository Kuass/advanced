package hello.advanced.app.v4

import hello.advanced.trace.TraceStatus
import hello.advanced.trace.logtrace.LogTrace
import hello.advanced.trace.template.AbstractTemplate
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class OrderControllerV4(
    val orderService: OrderServiceV4,
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