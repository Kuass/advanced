package kr.kua.demo_first.app.v0

import kr.kua.demo_first.app.v0.OrderServiceV0
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class OrderControllerV0(
    val orderService: OrderServiceV0
) {

    @GetMapping("/v0/request")
    fun request(itemId: String): String {
        orderService.orderItem(itemId)
        return "ok"
    }

}