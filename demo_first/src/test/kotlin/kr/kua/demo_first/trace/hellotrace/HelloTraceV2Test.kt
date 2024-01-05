package kr.kua.demo_first.trace.hellotrace

import kr.kua.demo_first.trace.hellotrace.HelloTraceV2
import org.junit.jupiter.api.Test

class HelloTraceV2Test {

    @Test
    fun begin_end() {
        val trace = HelloTraceV2()
        val status1 = trace.begin("hello1")
        val status2 = trace.beginSync(status1.getTraceId(), "hello2")
        trace.end(status2)
        trace.end(status1)
    }

    @Test
    fun begin_exception() {
        val trace = HelloTraceV2()
        val status1 = trace.begin("hello1")
        val status2 = trace.beginSync(status1.getTraceId(), "hello2")
        trace.exception(status2, IllegalStateException())
        trace.exception(status1, IllegalStateException())
    }
}