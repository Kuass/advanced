package kr.kua.demo_first.app.v2

import kr.kua.demo_first.trace.TraceStatus
import kr.kua.demo_first.trace.hellotrace.HelloTraceV2
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class OrderControllerV2(
    val orderService: OrderServiceV2,
    val trace: HelloTraceV2
) {

    @GetMapping("/v2/request")
    fun request(itemId: String): String {

        val status: TraceStatus = trace.begin("OrderControllerV2.request()")
        try {
            orderService.orderItem(status.getTraceId(), itemId)
            trace.end(status)
            return "ok"
        }catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }

}