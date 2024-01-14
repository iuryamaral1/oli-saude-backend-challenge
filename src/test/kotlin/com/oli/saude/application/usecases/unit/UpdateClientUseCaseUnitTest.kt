package com.oli.saude.application.usecases.unit

import com.oli.saude.application.usecases.clients.UpdateClientUseCaseImpl
import com.oli.saude.domain.exceptions.ClientNotFoundException
import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.models.clients.enums.Sex
import com.oli.saude.domain.repository.clients.ClientRepository
import com.oli.saude.util.TimeProvider
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class UpdateClientUseCaseUnitTest {

    private val timeProvider: TimeProvider = mock()
    private val clientRepository: ClientRepository = mock()
    private val updateClientUseCase = UpdateClientUseCaseImpl(clientRepository, timeProvider)

    @Test
    fun `Should throw error when client is not found by id`() {

        val client = Client(
            id = UUID.randomUUID(),
            name = "test",
            birthDate = LocalDate.now().minusYears(10),
            sex = Sex.F,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        `when`(clientRepository.findById(client.id!!)).thenReturn(Optional.empty())

        val exception = assertThrows<ClientNotFoundException> {
            updateClientUseCase(client)
        }

        assertEquals("Client not found for id: ${client.id}", exception.message)
    }

    @Test
    fun `Should update client successfully`() {

        val client = Client(
            id = UUID.randomUUID(),
            name = "test",
            birthDate = LocalDate.now().minusYears(10),
            sex = Sex.F,
            createdAt = LocalDateTime.of(2024, 1, 1, 0, 0, 0),
            updatedAt = LocalDateTime.of(2024, 1, 1, 0, 0, 0)
        )

        val clientToUpdate = Client(
            id = client.id!!,
            name = "test 2",
            birthDate = LocalDate.now().minusYears(11),
            sex = Sex.F,
            createdAt = client.createdAt,
            updatedAt = client.updatedAt
        )

        `when`(timeProvider.getCurrentDateTime()).thenReturn(LocalDateTime.of(2024, 1, 1, 0, 0, 0))
        `when`(clientRepository.findById(client.id!!)).thenReturn(Optional.of(client))
        `when`(clientRepository.save(clientToUpdate)).thenReturn(clientToUpdate)

        assertEquals(clientToUpdate, updateClientUseCase(clientToUpdate))
    }
}