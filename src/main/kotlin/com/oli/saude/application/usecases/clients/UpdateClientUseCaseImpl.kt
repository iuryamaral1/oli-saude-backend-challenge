package com.oli.saude.application.usecases.clients

import com.oli.saude.domain.exceptions.ClientNotFoundException
import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.repository.clients.ClientRepository
import com.oli.saude.util.TimeProvider
import org.springframework.stereotype.Component

@Component
class UpdateClientUseCaseImpl(
    private val clientRepository: ClientRepository,
    private val timeProvider: TimeProvider
) : UpdateClientUseCase {

    override fun invoke(client: Client): Client =
        kotlin.run {
            clientRepository.findById(client.id!!).takeIf { it.isPresent }?.get()
                ?: throw ClientNotFoundException("Client not found for id: ${client.id}")
        }.let {
            clientRepository.save(
                it.copy(
                    id = client.id,
                    name = client.name,
                    birthDate = client.birthDate,
                    sex = client.sex,
                    updatedAt = timeProvider.getCurrentDateTime()
                )
            )
        }
}