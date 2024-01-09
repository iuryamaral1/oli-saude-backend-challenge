package com.oli.saude.gateways.web.controllers

import com.oli.saude.application.usecases.clients.CreateClientUseCase
import com.oli.saude.gateways.web.dto.request.ClientRequestDTO
import com.oli.saude.gateways.web.dto.response.toResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/clients")
class ClientController(
    private val createClientUseCase: CreateClientUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createClient(@Valid @RequestBody clientRequestDTO: ClientRequestDTO) =
        createClientUseCase(clientRequestDTO.toDomain()).toResponse()
}