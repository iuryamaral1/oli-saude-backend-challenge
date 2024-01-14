package com.oli.saude.domain.repository.clients

import com.oli.saude.domain.models.clients.Client
import java.util.*

interface ClientRepository {

    fun save(client: Client): Client
    fun findById(id: UUID): Optional<Client>
}