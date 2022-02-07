package br.com.vfs.casadocodigoapi.domain.rule

import br.com.vfs.casadocodigoapi.domain.expection.AuthorExistsInSystemException
import br.com.vfs.casadocodigoapi.domain.gateway.AuthorDataGateway
import br.com.vfs.casadocodigoapi.domain.model.HasEmail

class ValidateAuthorEmailExistsInSystem private constructor(){
    companion object {
        fun execute(hasEmail: HasEmail, authorDataGateway: AuthorDataGateway) {
            authorDataGateway.findByEmail(hasEmail.email())
                ?.also { throw AuthorExistsInSystemException(hasEmail.email()) }
        }
    }
}