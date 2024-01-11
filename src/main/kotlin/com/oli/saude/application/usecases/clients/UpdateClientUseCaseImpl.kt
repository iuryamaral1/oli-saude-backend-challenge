package com.oli.saude.application.usecases.clients

import com.oli.saude.domain.exceptions.ClientNotFoundException
import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.repository.clients.ClientRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UpdateClientUseCaseImpl(
    private val clientRepository: ClientRepository
) : UpdateClientUseCase {

    override fun invoke(client: Client): Client {
        val clientFound = clientRepository.findById(client.id!!)
        if (clientFound.isEmpty) throw ClientNotFoundException("Client not found for id: ${client.id}")

        return clientRepository.save(client.copy(updatedAt = LocalDateTime.now()))
    }
}