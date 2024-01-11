package com.oli.saude.gateways.web.dto.request

import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.models.clients.enums.Sex
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.Size
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class ClientRequestDTO(
    @field:NotBlank(message = "name is required")
    @field:Size(min = 3, max = 255, message = "name must be between 3 and 255 characters")
    val name: String,

    @field:NotNull(message = "Sex is required. Use M or F options")
    val sex: Sex,

    @field:PastOrPresent(message = "Birth date must be a past or present date")
    @field:NotNull(message = "birthDate is required")
    @field:DateTimeFormat(pattern = "yyyy-MM-dd")
    val birthDate: LocalDate
) {

    fun toDomain(id: UUID? = null) = Client(
        id = id,
        name = name,
        sex = sex,
        birthDate = birthDate,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}
