package hello.advanced.trace.template

import hello.advanced.trace.strategy.code.strategy.ContextV1
import hello.advanced.trace.strategy.code.strategy.Strategy
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory


class ContextV1Test {
    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun strategyV0() {
        logic1()
        logic2()
    }

    private fun logic1() {
        val startTime = System.currentTimeMillis()
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행")
        //비즈니스 로직 종료
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info("resultTime= $resultTime")
    }

    private fun logic2() {
        val startTime = System.currentTimeMillis()
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행")
        //비즈니스 로직 종료
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info("resultTime= $resultTime")
    }

    /**
     * 전략 패턴 적용
     */
    @Test
    fun strategyV1() {
        val strategyLogic1: Strategy = StrategyLogic1()
        val context1 = ContextV1(strategyLogic1)
        context1.execute()
        val strategyLogic2: Strategy = StrategyLogic2()
        val context2 = ContextV1(strategyLogic2)
        context2.execute()
    }

    @Test
    fun strategyV2() {
        val strategyLogic1 = object : Strategy {
            override fun call() {
                log.info("비즈니스 로직1 실행")
            }
        }
        val context1 = ContextV1(strategyLogic1)
        log.info("strategyLogic1={}", strategyLogic1.javaClass)
        context1.execute()

        val strategyLogic2 = object : Strategy {
            override fun call() {
                log.info("비즈니스 로직2 실행")
            }
        }
        val context2 = ContextV1(strategyLogic2)
        log.info("strategyLogic2={}", strategyLogic2.javaClass)
        context2.execute()
    }

    @Test
    fun strategyV3() {
        val context1 = ContextV1(object : Strategy {
            override fun call() {
                log.info("비즈니스 로직1 실행")
            }
        })
        context1.execute()

        val context2 = ContextV1(object : Strategy {
            override fun call() {
                log.info("비즈니스 로직2 실행")
            }
        })
        context2.execute()
    }

    @Test
    fun strategyV4() {
        val context1 = ContextV1(object : Strategy {
            override fun call() = log.info("비즈니스 로직1 실행")
        })
        // https://www.baeldung.com/kotlin/lambda-expressions#1-object-expression
        // 참고바람, Kotlin은 이게 최선임
        context1.execute()
    }
}