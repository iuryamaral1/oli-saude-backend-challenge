package com.oli.saude

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SaudeApplication

fun main(args: Array<String>) {
	runApplication<SaudeApplication>(*args)
}
