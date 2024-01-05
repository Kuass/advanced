package kr.kua.demo_first.trace.threadlocal.code

import org.slf4j.LoggerFactory
import java.lang.Thread.sleep

class ThreadLocalService {
    private val log = LoggerFactory.getLogger(javaClass)

    private var nameStore: ThreadLocal<String> = ThreadLocal()

    fun logic(name: String): String {
        log.info("저장 name={} -> nameStore={}", name, nameStore.get())
        nameStore.set(name)
        sleep(1000)
        log.info("조회 nameStore={}", nameStore.get())
        return nameStore.get()
    }

}