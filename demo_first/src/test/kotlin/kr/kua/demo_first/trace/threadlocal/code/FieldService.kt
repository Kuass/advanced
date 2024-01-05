package kr.kua.demo_first.trace.threadlocal.code

import org.slf4j.LoggerFactory
import java.lang.Thread.sleep

class FieldService {
    private val log = LoggerFactory.getLogger(javaClass)

    private var nameStore: String? = null

    fun logic(name: String): String {
        log.info("저장 name={} -> nameStore={}", name, nameStore)
        nameStore = name
        sleep(1000)
        log.info("조회 nameStore={}", nameStore)
        return nameStore!!
    }

}