package kr.kua.demo_first.trace.template.code

import org.slf4j.LoggerFactory

class SubClassLogic1: AbstractTemplate() {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun call() {
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행")
        //비즈니스 로직 종료
    }
}