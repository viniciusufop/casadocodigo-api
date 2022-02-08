package br.com.vfs.casadocodigoapi.domain.usecase

import br.com.vfs.casadocodigoapi.domain.expection.AuthorDoNotExistException
import br.com.vfs.casadocodigoapi.domain.gateway.AuthorDataGateway
import org.springframework.stereotype.Service

@Service
class FindByIdAuthorUserCaseImpl(
    private val authorDataGateway: AuthorDataGateway
) : FindByIdAuthorUserCase {
    override fun execute(id: Long) =
        authorDataGateway.findById(id) ?: throw AuthorDoNotExistException(id)
}