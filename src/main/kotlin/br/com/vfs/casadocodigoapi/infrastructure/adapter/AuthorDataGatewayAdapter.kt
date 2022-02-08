package br.com.vfs.casadocodigoapi.infrastructure.adapter

import br.com.vfs.casadocodigoapi.domain.model.Author
import br.com.vfs.casadocodigoapi.domain.gateway.AuthorDataGateway
import br.com.vfs.casadocodigoapi.infrastructure.repository.AuthorRepository
import br.com.vfs.casadocodigoapi.infrastructure.repository.model.AuthorEntity
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthorDataGatewayAdapter(
    private val authorRepository: AuthorRepository
) : AuthorDataGateway {

    override fun save(author: Author) =
        AuthorEntity(author)
            .let { authorRepository.save(it) }
            .toModel()

    override fun findAll(): List<Author> =
        authorRepository.findAll().map { it.toModel() }

    override fun findById(id: Long) =
        authorRepository.findByIdOrNull(id)?.toModel()

    override fun findByEmail(email: String) =
        authorRepository.findByEmail(email)?.toModel()
}