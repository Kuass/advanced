package hello.advanced.trace.template

import hello.advanced.trace.strategy.code.strategy.*
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory


class ContextV2Test {
    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * 전략 패턴 적용
     */

    @Test
    fun strategyV1(){
        val context = ContextV2()
        context.execute(StrategyLogic1())
        context.execute(StrategyLogic2())
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    fun strategyV2() {
        val context = ContextV2()
        context.execute(object : Strategy {
            override fun call() {
                log.info("비즈니스 로직1 실행")
            }
        })
        context.execute(object : Strategy {
            override fun call() {
                log.info("비즈니스 로직2 실행")
            }
        })
    }

    /**
     * 전략 패턴 람다
     */
    @Test
    fun strategyV3() {
        val context = ContextV2()
        context.execute(object : Strategy {
            override fun call() {
                log.info("비즈니스 로직1 실행")
            }
        })
        context.execute(object : Strategy {
            override fun call() {
                log.info("비즈니스 로직2 실행")
            }
        })
    }


}