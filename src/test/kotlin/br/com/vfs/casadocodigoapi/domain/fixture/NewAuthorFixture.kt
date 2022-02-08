package br.com.vfs.casadocodigoapi.domain.fixture

import br.com.vfs.casadocodigoapi.domain.input.NewAuthor
import br.com.vfs.casadocodigoapi.domain.model.Author
import java.time.LocalDateTime

class NewAuthorFixture private constructor() {
    companion object {
        fun new(
            email: String = "teste@email",
            name: String = "Test",
            description: String = "test",
        ) =
            NewAuthor(
                email = email,
                name = name,
                description = description,
            )
    }
}