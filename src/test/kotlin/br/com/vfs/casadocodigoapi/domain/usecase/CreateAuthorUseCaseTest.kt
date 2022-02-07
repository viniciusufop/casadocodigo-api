package br.com.vfs.casadocodigoapi.domain.usecase

import br.com.vfs.casadocodigoapi.domain.model.Author
import br.com.vfs.casadocodigoapi.domain.input.NewAuthor
import br.com.vfs.casadocodigoapi.domain.expection.AuthorExistsInSystemException
import br.com.vfs.casadocodigoapi.domain.gateway.AuthorDataGateway
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.eq
import java.time.LocalDateTime


@ExtendWith(MockitoExtension::class)
class CreateAuthorUseCaseTest {

    @Mock
    lateinit var authorDataGateway: AuthorDataGateway

    @InjectMocks
    lateinit var createAuthorUseCase: CreateAuthorUseCaseImpl

    @Test
    fun `should throw AuthorExistsInSystemException when author's email exists in system`() {
        Mockito.`when`(authorDataGateway.findByEmail(Mockito.anyString())).thenReturn(buildAuthor())
        Assertions.assertThrows(AuthorExistsInSystemException::class.java) {
            createAuthorUseCase.execute(buildNewAuthor())
        }
    }

    @Test
    fun `should author when author's email don't exist in system`() {
        val newAuthor = buildNewAuthor()
        Mockito.`when`(authorDataGateway.findByEmail(Mockito.anyString())).thenReturn(null)
        Mockito.`when`(authorDataGateway.create(eq(newAuthor))).thenReturn(buildAuthor())
        Assertions.assertDoesNotThrow {
            val saveAuthor: Author = createAuthorUseCase.execute(newAuthor)
            Assertions.assertEquals(newAuthor.email, saveAuthor.email)
        }
    }

    private fun buildNewAuthor() =
        NewAuthor(
            "teste@email", "TEst", "teste"
        )

    private fun buildAuthor() =
        Author(
            1, "teste@email", "TEst", "teste", LocalDateTime.now()
        )
}