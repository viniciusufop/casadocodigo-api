package br.com.vfs.casadocodigoapi.domain.usecase

import br.com.vfs.casadocodigoapi.domain.model.Author

interface FindByIdAuthorUserCase {
    fun execute(id: Long): Author
}