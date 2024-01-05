package kr.kua.demo_first.trace.threadlocal

import kr.kua.demo_first.trace.threadlocal.code.ThreadLocalService
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import java.lang.Thread.sleep

class ThreadLocalServiceTest {
    private val log = LoggerFactory.getLogger(javaClass)

    val threadLocalService = ThreadLocalService()

    @Test
    fun field() {
        log.info("main start")
        val userA: Runnable = Runnable {
            threadLocalService.logic("userA")
        }
        val userB: Runnable = Runnable {
            threadLocalService.logic("userB")
        }

        val threadA = Thread(userA)
        threadA.name = "thread-A"
        val threadB = Thread(userB)
        threadB.name = "thread-B"

        threadA.start()
//        sleep(2000) // 동시성 문제 발생 X
        sleep(100) // 동시성 문제 발생 O
        threadB.start()

        sleep(3000) // 메인 쓰레드 종료 대기
        log.info("main exit")
    }
}