package br.com.vfs.casadocodigoapi.infrastructure.adapter

import br.com.vfs.casadocodigoapi.domain.model.Author
import br.com.vfs.casadocodigoapi.domain.gateway.AuthorDataGateway
import br.com.vfs.casadocodigoapi.infrastructure.repository.AuthorRepository
import br.com.vfs.casadocodigoapi.infrastructure.resource.validator.model.AuthorEntity
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
        authorRepository.findAll().filterNotNull()
            .map {
                Author(
                    id = it.id,
                    email = it.email,
                    name = it.name,
                    description = it.description,
                    createdAt = it.createdAt
                )
            }

    override fun findById(id: Long): Author? {
        return authorRepository.findById(id)
            .orElse(null)?.let {
                Author(
                    id = it.id,
                    email = it.email,
                    name = it.name,
                    description = it.description,
                    createdAt = it.createdAt
                )
            };
    }

    override fun findByEmail(email: String) =
        authorRepository.findByEmail(email)?.toModel()

}