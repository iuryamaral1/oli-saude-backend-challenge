package com.oli.saude.application.usecases.clients

import com.oli.saude.domain.models.clients.Client
import java.util.UUID

interface FindClientUseCase {

    fun findClientById(id: UUID): Client
}