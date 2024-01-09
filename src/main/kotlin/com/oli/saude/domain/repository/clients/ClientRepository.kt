package com.oli.saude.domain.repository.clients

import com.oli.saude.domain.models.clients.Client

interface ClientRepository {

    fun save(client: Client): Client
}