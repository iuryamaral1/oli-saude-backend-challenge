package com.oli.saude.application.usecases.integration

import com.oli.saude.TestIntegration
import com.oli.saude.application.usecases.clients.CreateClientUseCase
import com.oli.saude.domain.exceptions.CreateClientException
import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.models.clients.enums.Sex
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Objects

class CreateClientUseCaseIntegrationTest : TestIntegration() {

    @Autowired
    private lateinit var createClientUseCase: CreateClientUseCase

    @Test
    fun `should create client`() {
        val client = Client(
            name = "Oli",
            birthDate = LocalDate.now().minusYears(20),
            sex = Sex.M,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        val createdClient = createClientUseCase(client)

        assertTrue(createdClient.id != null)
        assertEquals(createdClient.name, client.name)
        assertEquals(createdClient.birthDate, client.birthDate)
        assertTrue(Objects.nonNull(createdClient.createdAt))
        assertTrue(Objects.nonNull(createdClient.updatedAt))
    }

    @Test
    fun `Should throw CreateClientException error when it could not save a new client`() {

        val client = Client(
            name = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque suscipit fermentum felis. Morbi ac condimentum tortor. Nulla ac congue neque. Cras ultricies efficitur mattis. Etiam dapibus dui odio, nec feugiat nibh ultrices vel. Integer quis sem tincidunt, porta dui id, dignissim justo. Suspendisse sit amet ex libero. Praesent interdum felis vitae nisl rhoncus laoreet. Mauris vel bibendum nisl. Duis laoreet nec leo vitae pretium. Praesent massa risus, feugiat sit amet pellentesque vitae, pretium non mi. In hac habitasse platea dictumst.\n" +
                    "\n" +
                    "Nullam et dictum quam. Proin hendrerit, odio et posuere malesuada, arcu velit aliquet nisi, eu suscipit nisl arcu non nisl. Nunc sed tincidunt tortor. Integer porta leo in magna ullamcorper porttitor. Nam eget lacus mollis ligula mattis fermentum. Sed leo nunc, cursus vitae laoreet eget, dapibus ac ipsum. Donec tincidunt metus ex, sit amet lacinia lacus pulvinar eget. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas maximus porta turpis, sed ullamcorper libero. In nec erat eu dolor ullamcorper luctus.",
            birthDate = LocalDate.now().minusYears(10),
            sex = Sex.F,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        assertThrows<CreateClientException> { createClientUseCase(client) }
    }
}