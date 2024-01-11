package com.oli.saude.domain.exceptions

data class ClientNotFoundException(override val message: String) : RuntimeException(message)