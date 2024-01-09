package com.oli.saude.gateways.web.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.oli.saude.domain.models.clients.Client
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class ClientResponseDTO(
    val id: UUID,
    val name: String,
    val sex: String,

    @JsonFormat(pattern = "dd/MM/yyyy")
    val birthDate: LocalDate,

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    val createdAt: LocalDateTime,

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    val updatedAt: LocalDateTime
)

fun Client.toResponse() = ClientResponseDTO(
    id = id!!,
    name = name,
    sex = sex.name,
    birthDate = birthDate,
    createdAt = createdAt,
    updatedAt = updatedAt
)