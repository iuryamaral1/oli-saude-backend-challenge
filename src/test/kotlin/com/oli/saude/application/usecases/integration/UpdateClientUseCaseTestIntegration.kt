package com.oli.saude.application.usecases.integration

import com.oli.saude.TestIntegration
import com.oli.saude.application.usecases.clients.UpdateClientUseCase
import com.oli.saude.domain.exceptions.ClientNotFoundException
import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.models.clients.enums.Sex
import com.oli.saude.domain.repository.clients.ClientRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class UpdateClientUseCaseTestIntegration : TestIntegration() {

    @Autowired
    private lateinit var clientRepository: ClientRepository

    @Autowired
    private lateinit var updateClientUseCase: UpdateClientUseCase

    @Test
    fun `Should throw error when client is not found by id`() {

        val client = Client(
            id = UUID.randomUUID(),
            name = "Test",
            birthDate = LocalDate.now().minusYears(15),
            sex = Sex.M,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        val exception = assertThrows<ClientNotFoundException> {
            updateClientUseCase(client)
        }

        assertEquals("Client not found for id: ${client.id}", exception.message)
    }

    @Test
    fun `Should update client successfully`() {

        val client = Client(
            name = "Test",
            birthDate = LocalDate.now().minusYears(10),
            sex = Sex.F,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        val createdClient = clientRepository.save(client)

        val clientToUpdate = Client(
            id = createdClient.id,
            name = "Test 2",
            sex = Sex.F,
            birthDate = LocalDate.now().minusYears(20),
            createdAt = client.createdAt,
            updatedAt = LocalDateTime.now()
        )

        updateClientUseCase(clientToUpdate)

        val updatedClient = clientRepository.findById(clientToUpdate.id!!).get()

        assertEquals(updatedClient.id, createdClient.id)
        assertEquals(updatedClient.name, clientToUpdate.name)
        assertEquals(updatedClient.birthDate, clientToUpdate.birthDate)
        assertEquals(updatedClient.sex, clientToUpdate.sex)
    }
}