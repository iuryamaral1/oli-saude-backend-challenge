package com.oli.saude.gateways.persistence.data

import com.oli.saude.gateways.persistence.entity.ClientEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface JpaClientRepository : CrudRepository<ClientEntity, UUID> {
}