package br.com.vfs.casadocodigoapi.domain.model

import java.time.LocalDateTime

data class Author(
    var id: Long,
    val email: String,
    val name: String,
    val description: String,
    var createdAt: LocalDateTime
) : HasEmail {
    override fun email() = email

    fun toModel() =
        Author(
            id = 0,
            email = email,
            name = name,
            description = description,
            createdAt = LocalDateTime.now()
        )
}