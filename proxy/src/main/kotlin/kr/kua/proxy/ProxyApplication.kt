package kr.kua.proxy

import kr.kua.proxy.config.AppV1Config
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(AppV1Config::class)
@SpringBootApplication(scanBasePackages = ["kr.kua.proxy.app"])
class ProxyApplication

fun main(args: Array<String>) {
    runApplication<ProxyApplication>(*args)
}
