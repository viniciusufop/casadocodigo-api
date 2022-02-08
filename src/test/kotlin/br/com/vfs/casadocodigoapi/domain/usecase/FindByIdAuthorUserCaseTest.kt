package br.com.vfs.casadocodigoapi.domain.usecase

import br.com.vfs.casadocodigoapi.domain.expection.AuthorDoNotExistException
import br.com.vfs.casadocodigoapi.domain.expection.AuthorExistsInSystemException
import br.com.vfs.casadocodigoapi.domain.fixture.AuthorFixture
import br.com.vfs.casadocodigoapi.domain.gateway.AuthorDataGateway
import br.com.vfs.casadocodigoapi.domain.model.Author
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import java.time.LocalDateTime

@ExtendWith(MockitoExtension::class)
class FindByIdAuthorUserCaseTest {

    @Mock
    lateinit var authorDataGateway: AuthorDataGateway

    @InjectMocks
    lateinit var findByIdAuthorUserCaseImpl: FindByIdAuthorUserCaseImpl

    @Test
    fun `should throw AuthorDoNotExistException when author's id don't exists in system`() {
        val id = 2L
        Mockito.`when`(authorDataGateway.findById(eq(id))).thenReturn(null)
        Assertions.assertThrows(AuthorDoNotExistException::class.java) {
            findByIdAuthorUserCaseImpl.execute(id)
        }
    }



    @Test
    fun `should return author when author's id exist in system`() {
        val author = AuthorFixture.new(
            email = "batata@email",
            name = "Erick",
            description = "aventura"
        )
        val id = 1L
        Mockito.`when`(authorDataGateway.findById(eq(id))).thenReturn(author)
        Assertions.assertDoesNotThrow {
            val findAuthorById: Author = findByIdAuthorUserCaseImpl.execute(id)
            Assertions.assertEquals(author, findAuthorById)
        }
    }
}