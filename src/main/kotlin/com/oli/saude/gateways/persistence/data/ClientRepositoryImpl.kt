package com.oli.saude.gateways.persistence.data

import com.oli.saude.domain.models.clients.Client
import com.oli.saude.domain.repository.clients.ClientRepository
import com.oli.saude.gateways.persistence.entity.toEntity
import org.springframework.stereotype.Component

@Component
class ClientRepositoryImpl(
    val jpaClientRepository: JpaClientRepository
) : ClientRepository {

    override fun save(client: Client) =
        jpaClientRepository.save(client.toEntity()).toModel()
}