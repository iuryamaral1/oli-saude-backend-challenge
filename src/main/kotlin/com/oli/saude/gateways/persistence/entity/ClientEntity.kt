package com.oli.saude.gateways.persistence.entity

import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.models.clients.enums.Sex
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "clients")
data class ClientEntity(

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID? = null,

    @Column(name = "name", nullable = false, length = 255)
    val name: String,

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    val birthDate: LocalDate,

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false, length = 1)
    val sex: Sex,

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime
) {
    fun toModel() = Client(
        id = id,
        name = name,
        birthDate = birthDate,
        sex = sex,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun Client.toEntity() =
    ClientEntity(
        id = id,
        name = name,
        birthDate = birthDate,
        sex = sex,
        createdAt = createdAt,
        updatedAt = updatedAt
    )