package kr.kua.proxy.app.v1

import java.lang.Thread.sleep

class OrderRepositoryV1Impl : OrderRepositoryV1 {
    override fun save(itemId: String) {
        if (itemId == "ex") {
            throw IllegalStateException("예외 발생!")
        }
        sleep(1000)
    }
}