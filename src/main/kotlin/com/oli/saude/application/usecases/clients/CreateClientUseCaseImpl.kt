package com.oli.saude.application.usecases.clients

import com.oli.saude.domain.exceptions.CreateClientException
import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.repository.clients.ClientRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Component
class CreateClientUseCaseImpl(
    private val clientRepository: ClientRepository
) : CreateClientUseCase {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun invoke(client: Client) = kotlin.runCatching {
        clientRepository.save(client)
    }.getOrElse {
        logger.error("[CLIENT_CREATION_ERROR]: Error when trying to save client", it)
        throw CreateClientException("Error when trying to save client with this message: ${it.message}")
    }
}