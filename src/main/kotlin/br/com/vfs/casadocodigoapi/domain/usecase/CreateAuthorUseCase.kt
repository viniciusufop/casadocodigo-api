package br.com.vfs.casadocodigoapi.domain.usecase

import br.com.vfs.casadocodigoapi.domain.model.Author
import br.com.vfs.casadocodigoapi.domain.input.NewAuthor

interface CreateAuthorUseCase {

    fun execute(newAuthor: NewAuthor): Author
}