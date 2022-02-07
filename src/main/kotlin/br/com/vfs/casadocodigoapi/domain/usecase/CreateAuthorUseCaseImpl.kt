package br.com.vfs.casadocodigoapi.domain.usecase

import br.com.vfs.casadocodigoapi.domain.model.Author
import br.com.vfs.casadocodigoapi.domain.input.NewAuthor
import br.com.vfs.casadocodigoapi.domain.gateway.AuthorDataGateway
import br.com.vfs.casadocodigoapi.domain.rule.ValidateAuthorEmailExistsInSystem
import org.springframework.stereotype.Service

@Service
class CreateAuthorUseCaseImpl(
    private val authorDataGateway: AuthorDataGateway
) : CreateAuthorUseCase{

    override fun execute(newAuthor: NewAuthor): Author {
        //Proximos passos, mudar o gateway para author
        val author = newAuthor.toModel()
        ValidateAuthorEmailExistsInSystem.execute(author, authorDataGateway)
        return authorDataGateway.create(newAuthor)
    }
}