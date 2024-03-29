package kr.kua.demo_first.app.v4

import kr.kua.demo_first.trace.logtrace.LogTrace
import kr.kua.demo_first.trace.template.AbstractTemplate
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class OrderRepositoryV4(
    val trace: LogTrace
) {

    fun save(itemId: String) {
        val template: AbstractTemplate<Unit> = object : AbstractTemplate<Unit>(trace) {
            override fun call() {
                if (itemId == "ex") {
                    throw IllegalStateException("예외 발생!")
                }
                sleep(1000)
            }
        }
        return template.execute("OrderRepositoryV4.save()")
    }

    private fun sleep(millis: Int) {
        Thread.sleep(millis.toLong())
    }
}