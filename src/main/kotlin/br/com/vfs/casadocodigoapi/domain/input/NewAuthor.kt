package br.com.vfs.casadocodigoapi.domain.input

import br.com.vfs.casadocodigoapi.domain.model.Author
import br.com.vfs.casadocodigoapi.domain.model.HasEmail
import java.time.LocalDateTime

data class NewAuthor(
    val email: String,
    val name: String,
    val description: String
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