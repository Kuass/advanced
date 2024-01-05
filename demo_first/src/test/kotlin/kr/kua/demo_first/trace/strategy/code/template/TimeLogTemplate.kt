package kr.kua.demo_first.trace.strategy.code.template

import org.slf4j.LoggerFactory

class TimeLogTemplate {
    private val log = LoggerFactory.getLogger(javaClass)

    fun execute(callback: Callback) {
        val startTime = System.currentTimeMillis()
        //비즈니스 로직 실행
        callback.call() //위임
        //비즈니스 로직 종료
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info("resultTime={}", resultTime)
    }
}