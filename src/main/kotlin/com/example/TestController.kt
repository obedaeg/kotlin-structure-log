package com.example

import net.logstash.logback.argument.StructuredArguments.keyValue
import net.logstash.logback.argument.StructuredArguments.kv
import net.logstash.logback.argument.StructuredArguments.v
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException
import java.util.*

@RestController
class TestController{
    private val log = LoggerFactory.getLogger(com.example.TestController::class.java)

    @GetMapping("/log")
    fun testlog(@RequestParam(value = "name", defaultValue = "World!") name: String): String {
        log.info("{} Hello {}",kv("parameter", "first"), kv("name", name))
        log.warn("Hello {}", v("name", name))
        log.error("Hello {}", keyValue("name", name))

        return "Hello $name"
    }
}