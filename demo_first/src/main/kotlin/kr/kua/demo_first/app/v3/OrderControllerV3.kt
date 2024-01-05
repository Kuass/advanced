package kr.kua.demo_first.app.v3

import kr.kua.demo_first.trace.TraceStatus
import kr.kua.demo_first.trace.logtrace.LogTrace
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class OrderControllerV3(
    val orderService: OrderServiceV3,
    val trace: LogTrace
) {

    @GetMapping("/v3/request")
    fun request(itemId: String): String {

        val status: TraceStatus = trace.begin("OrderControllerV3.request()")
        try {
            orderService.orderItem(itemId)
            trace.end(status)
            return "ok"
        }catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }

}