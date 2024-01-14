package com.oli.saude.util

import java.time.LocalDateTime

interface TimeProvider {

    fun getCurrentDateTime(): LocalDateTime
}