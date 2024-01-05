package kr.kua.demo_first

import kr.kua.demo_first.trace.logtrace.LogTrace
import kr.kua.demo_first.trace.logtrace.ThreadLocalLogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LogTraceConfig {

    @Bean
    fun logTrace(): LogTrace {
        return ThreadLocalLogTrace()
    } // 싱글톤 인스턴스 등록

}