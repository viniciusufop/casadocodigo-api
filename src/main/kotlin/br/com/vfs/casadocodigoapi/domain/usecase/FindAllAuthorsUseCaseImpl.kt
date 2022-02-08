package br.com.vfs.casadocodigoapi.domain.usecase

import br.com.vfs.casadocodigoapi.domain.gateway.AuthorDataGateway
import org.springframework.stereotype.Service

@Service
class FindAllAuthorsUseCaseImpl(
    private val authorDataGateway: AuthorDataGateway
): FindAllAuthorsUseCase {

    override fun execute() = authorDataGateway.findAll()
}