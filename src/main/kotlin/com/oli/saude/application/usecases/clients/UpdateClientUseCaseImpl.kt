package com.oli.saude.application.usecases.clients

import com.oli.saude.domain.exceptions.ClientNotFoundException
import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.repository.clients.ClientRepository
import com.oli.saude.util.TimeProvider
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UpdateClientUseCaseImpl(
    private val clientRepository: ClientRepository,
    private val timeProvider: TimeProvider
) : UpdateClientUseCase {

    override fun invoke(clientToUpdate: Client): Client =
        kotlin.run {
            clientRepository.findById(clientToUpdate.id!!).takeIf { it.isPresent }?.get()
                ?: throw ClientNotFoundException("Client not found for id: ${clientToUpdate.id}")
        }.let {
            clientRepository.save(
                it.copy(
                    id = clientToUpdate.id,
                    name = clientToUpdate.name,
                    birthDate = clientToUpdate.birthDate,
                    sex = clientToUpdate.sex,
                    updatedAt = timeProvider.getCurrentDateTime()
                )
            )
        }
}