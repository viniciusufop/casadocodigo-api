package br.com.vfs.casadocodigoapi.infrastructure.resource.v1.response

import br.com.vfs.casadocodigoapi.domain.model.Author
import java.time.LocalDateTime

data class AuthorResponse(
    val id: Long,
    val email: String,
    val name: String,
    val description: String,
    val createdAt: LocalDateTime
) {
    constructor(author: Author) : this(
        id = author.id,
        email = author.email,
        name = author.name,
        description = author.description,
        createdAt = author.createdAt
    )
}
