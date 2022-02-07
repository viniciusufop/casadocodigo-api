package br.com.vfs.casadocodigoapi.domain.usecase

import br.com.vfs.casadocodigoapi.domain.model.Author
import br.com.vfs.casadocodigoapi.domain.input.NewAuthor

interface AuthorService {
    /*
        meu caso de uso é criar um novo autor
     */
    fun create(newAuthor: NewAuthor): Author

    fun findAll(): List<Author>

    fun findById(id: Long): Author
}