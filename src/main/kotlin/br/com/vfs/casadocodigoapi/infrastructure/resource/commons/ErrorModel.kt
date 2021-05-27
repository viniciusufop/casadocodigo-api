package br.com.vfs.casadocodigoapi.infrastructure.resource.commons

import java.time.LocalDateTime

data class ErrorModel(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val errors: List<String>,
    val path: String
)
