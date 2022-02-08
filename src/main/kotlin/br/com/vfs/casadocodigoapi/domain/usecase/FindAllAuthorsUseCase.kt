package br.com.vfs.casadocodigoapi.domain.usecase

import br.com.vfs.casadocodigoapi.domain.model.Author

interface FindAllAuthorsUseCase {
    fun execute(): List<Author>
}