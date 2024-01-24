package com.oli.saude.application.usecases.clients

import com.oli.saude.domain.exceptions.ClientNotFoundException
import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.repository.clients.ClientRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class FindClientUseCaseImpl(
        private val clientRepository: ClientRepository
) : FindClientUseCase {

    override fun findClientById(id: UUID): Client =
            clientRepository.findById(id).takeIf { it.isPresent }?.get() ?: throw ClientNotFoundException("Client not found")
}