package hello.advanced.trace.strategy.code.strategy

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class ContextV2() {
    private val log = LoggerFactory.getLogger(javaClass)

    fun execute(strategy: Strategy) {
        val startTime = System.currentTimeMillis()
        //비즈니스 로직 실행
        strategy.call() //위임
        //비즈니스 로직 종료
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info("resultTime={}", resultTime)
    }

}