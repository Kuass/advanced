package hello.advanced.trace.template.code

import org.slf4j.LoggerFactory

class SubClassLogic2: AbstractTemplate() {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun call() {
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행")
        //비즈니스 로직 종료
    }
}