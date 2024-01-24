package com.oli.saude.gateways.web.controllers

import com.oli.saude.application.usecases.clients.CreateClientUseCase
import com.oli.saude.application.usecases.clients.FindClientUseCase
import com.oli.saude.application.usecases.clients.UpdateClientUseCase
import com.oli.saude.gateways.web.dto.request.ClientRequestDTO
import com.oli.saude.gateways.web.dto.response.toResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/v1/clients")
class ClientController(
    private val createClientUseCase: CreateClientUseCase,
    private val updateClientUseCase: UpdateClientUseCase,
    private val findClientUseCase: FindClientUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createClient(@Valid @RequestBody clientRequestDTO: ClientRequestDTO) =
        createClientUseCase(clientRequestDTO.toDomain()).toResponse()

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateClient(@Valid @RequestBody updateClientRequestDTO: ClientRequestDTO, @PathVariable id: UUID) =
        updateClientUseCase(updateClientRequestDTO.toDomain(id)).toResponse()

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findClientById(@PathVariable id: UUID) =
        findClientUseCase.findClientById(id).toResponse()
}