package com.oli.saude.application.usecases.integration

import com.oli.saude.TestIntegration
import com.oli.saude.application.usecases.clients.FindClientUseCase
import com.oli.saude.domain.exceptions.ClientNotFoundException
import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.models.clients.enums.Sex
import com.oli.saude.domain.repository.clients.ClientRepository
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

class FindClientUseCaseIntegrationTest : TestIntegration() {

    @Autowired
    private lateinit var findClientUseCase: FindClientUseCase

    @Autowired
    private lateinit var clientRepository: ClientRepository

    @Test
    fun `Should throw error when it cannot find user`() {

        val id = UUID.randomUUID()

        val exception = assertThrows<ClientNotFoundException> {
            findClientUseCase.findClientById(id)
        }

        assertEquals("Client not found", exception.message)
    }

    @Test
    fun `Should find client by id`() {

        val client = Client(
            name = "Test",
            birthDate = LocalDate.now().minusYears(20),
            sex = Sex.M,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        val createdClient = clientRepository.save(client)

        val foundClient = findClientUseCase.findClientById(createdClient.id!!)

        assertEquals(createdClient.id, foundClient.id)
        assertEquals(createdClient.name, foundClient.name)
        assertEquals(createdClient.birthDate, foundClient.birthDate)
        assertEquals(createdClient.sex, foundClient.sex)
    }
}