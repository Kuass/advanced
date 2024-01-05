package kr.kua.demo_first.app.v1

import kr.kua.demo_first.trace.TraceStatus
import kr.kua.demo_first.trace.hellotrace.HelloTraceV1
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class OrderControllerV1(
    val orderService: OrderServiceV1,
    val trace: HelloTraceV1
) {

    @GetMapping("/v1/request")
    fun request(itemId: String): String {

        val status: TraceStatus = trace.begin("OrderControllerV1.request()")
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