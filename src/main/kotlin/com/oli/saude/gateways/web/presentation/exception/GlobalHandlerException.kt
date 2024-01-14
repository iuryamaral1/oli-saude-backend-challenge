package com.oli.saude.gateways.web.presentation.exception

import com.oli.saude.domain.exceptions.ClientNotFoundException
import com.oli.saude.domain.exceptions.CreateClientException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springdoc.api.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

const val GENERIC_ERROR_MSG = "We are sorry, but something went wrong."

@RestControllerAdvice
class GlobalHandlerException {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @ExceptionHandler(CreateClientException::class)
    fun handleCreateClientException(e: CreateClientException): ResponseEntity<ErrorResponse> =
        ResponseEntity.badRequest().body(ErrorResponse(e.message!!))

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception):ResponseEntity<ErrorResponse> =
        ResponseEntity.internalServerError().body(ErrorResponse(GENERIC_ERROR_MSG))
            .also { logger.error("[GENERIC_ERROR]: Error when trying to process request", e) }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val errorMessage = e.bindingResult.fieldErrors.joinToString(separator = ", ") { it.defaultMessage!! }
        return ResponseEntity.badRequest().body(ErrorResponse(errorMessage))
    }

    @ExceptionHandler(ClientNotFoundException::class)
    fun handleClientNotFoundException(e: ClientNotFoundException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(e.message))
}