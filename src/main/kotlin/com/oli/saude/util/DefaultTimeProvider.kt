package com.oli.saude.util

import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class DefaultTimeProvider : TimeProvider {

    override fun getCurrentDateTime(): LocalDateTime = LocalDateTime.now()
}