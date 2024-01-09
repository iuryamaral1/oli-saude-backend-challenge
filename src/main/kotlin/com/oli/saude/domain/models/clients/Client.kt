package com.oli.saude.domain.models.clients

import com.oli.saude.domain.models.clients.enums.Sex
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class Client(
    val id: UUID? = null,
    val name: String,
    val birthDate: LocalDate,
    val sex: Sex,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
