package hello.advanced

import hello.advanced.trace.logtrace.FieldLogTrace
import hello.advanced.trace.logtrace.LogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LogTraceConfig {

    @Bean
    fun logTrace(): LogTrace {
        return FieldLogTrace()
    } // 싱글톤 인스턴스 등록

}