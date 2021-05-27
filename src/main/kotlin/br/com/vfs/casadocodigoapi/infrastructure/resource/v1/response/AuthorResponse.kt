package br.com.vfs.casadocodigoapi.infrastructure.resource.v1.response

import java.time.LocalDateTime

data class AuthorResponse(
    val id: Long,
    val email: String,
    val name: String,
    val description: String,
    val createdAt: LocalDateTime
)
