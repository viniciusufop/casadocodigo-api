package br.com.vfs.casadocodigoapi.domain.usecase

import br.com.vfs.casadocodigoapi.domain.model.Author
import br.com.vfs.casadocodigoapi.domain.input.NewAuthor
import br.com.vfs.casadocodigoapi.domain.gateway.AuthorDataGateway
import br.com.vfs.casadocodigoapi.expection.ElementNotExistException
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorDataGateway: AuthorDataGateway
) : AuthorService{

    override fun create(newAuthor: NewAuthor): Author {
        return authorDataGateway.create(newAuthor)
    }

    override fun findAll() = authorDataGateway.findAll()
    override fun findById(id: Long) : Author {
        return authorDataGateway.findById(id) ?: throw ElementNotExistException("author don't exist")
    }

}