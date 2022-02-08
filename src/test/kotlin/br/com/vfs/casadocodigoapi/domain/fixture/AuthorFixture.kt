package br.com.vfs.casadocodigoapi.domain.fixture

import br.com.vfs.casadocodigoapi.domain.model.Author
import java.time.LocalDateTime

class AuthorFixture private constructor() {
    companion object {
        fun new(
            id: Long = 1,
            email: String = "teste@email",
            name: String = "Test",
            description: String = "test",
            createdAt: LocalDateTime = LocalDateTime.now()
        ) =
            Author(
                id = id,
                email = email,
                name = name,
                description = description,
                createdAt = createdAt
            )
    }
}