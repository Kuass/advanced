package hello.advanced.trace.strategy.code.strategy

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class ContextV1(private val strategy: Strategy) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun execute() {
        val startTime = System.currentTimeMillis()
        //비즈니스 로직 실행
        strategy.call() //위임
        //비즈니스 로직 종료
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info("resultTime={}", resultTime)
    }

    @Test
    fun strategyV1() {
        val strategyLogic1: Strategy = StrategyLogic1()
        val context1 = ContextV1(strategyLogic1)
        context1.execute()
        val strategyLogic2: Strategy = StrategyLogic2()
        val context2 = ContextV1(strategyLogic2)
        context2.execute()
    }
}