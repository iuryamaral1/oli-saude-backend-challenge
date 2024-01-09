package com.oli.saude.application.usecases.clients

import com.oli.saude.domain.models.clients.Client

interface CreateClientUseCase {

    operator fun invoke(client: Client): Client
}