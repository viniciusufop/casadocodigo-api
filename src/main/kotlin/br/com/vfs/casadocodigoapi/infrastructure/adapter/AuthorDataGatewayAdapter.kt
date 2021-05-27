package br.com.vfs.casadocodigoapi.infrastructure.adapter

import br.com.vfs.casadocodigoapi.domain.entities.Author
import br.com.vfs.casadocodigoapi.domain.entities.NewAuthor
import br.com.vfs.casadocodigoapi.domain.gateway.AuthorDataGateway
import br.com.vfs.casadocodigoapi.expection.ElementNotExistException
import br.com.vfs.casadocodigoapi.infrastructure.model.AuthorEntity
import br.com.vfs.casadocodigoapi.infrastructure.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorDataGatewayAdapter(
    private val authorRepository: AuthorRepository
) : AuthorDataGateway {
    override fun create(newAuthor: NewAuthor) = authorRepository.save(AuthorEntity(
            email = newAuthor.email,
            name = newAuthor.name,
            description = newAuthor.description
        )).let { Author(
            id = it.id,
            email = it.email,
            name = it.name,
            description = it.description,
            createdAt = it.createdAt
        ) }

    override fun findAll(): List<Author> =
        authorRepository.findAll().filterNotNull()
            .map { Author(
                id = it.id,
                email = it.email,
                name = it.name,
                description = it.description,
                createdAt = it.createdAt
            ) }

    override fun findById(id: Long): Author? {
        return authorRepository.findById(id)
            .orElse(null)?.let { Author(
            id = it.id,
            email = it.email,
            name = it.name,
            description = it.description,
            createdAt = it.createdAt
        ) };
    }
}