package hello.advanced.app.v0

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderServiceV0(
    val orderRepository: OrderRepositoryV0
) {

    fun orderItem(itemId: String) {
        orderRepository.save(itemId)
    }

}