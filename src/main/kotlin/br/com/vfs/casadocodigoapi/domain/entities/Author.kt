package br.com.vfs.casadocodigoapi.domain.entities

import java.time.LocalDateTime

data class Author(
    var id: Long,
    val email: String,
    val name: String,
    val description: String,
    var createdAt: LocalDateTime
)