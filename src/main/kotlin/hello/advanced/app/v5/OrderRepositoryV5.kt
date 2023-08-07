package hello.advanced.app.v5

import hello.advanced.trace.callback.TraceTemplate
import hello.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV5(trace: LogTrace) {
    private var template: TraceTemplate = TraceTemplate(trace)

    fun save(itemId: String) {
        template.execute<Any>("OrderRepository.save()") {
            //저장 로직
            check(itemId != "ex") { "예외 발생!" }
            sleep(1000)
        }
    }

    private fun sleep(millis: Int) {
        Thread.sleep(millis.toLong())
    }
}