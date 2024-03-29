package kr.kua.demo_first.trace.strategy

import kr.kua.demo_first.trace.strategy.code.template.Callback
import kr.kua.demo_first.trace.strategy.code.template.TimeLogTemplate
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class TemplateCallbackTest {
    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     * 템플릿 콜백 패턴 - 람다
     */
    @Test
    fun callbackV1() {
        val template = TimeLogTemplate()
        template.execute(object : Callback {
            override fun call() {
                log.info("비즈니스 로직1 실행")
            }
        })

        template.execute(object : Callback {
            override fun call() {
                log.info("비즈니스 로직2 실행")
            }
        })
    }
}