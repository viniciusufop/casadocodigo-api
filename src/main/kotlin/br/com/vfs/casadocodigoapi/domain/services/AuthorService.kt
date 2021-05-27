package br.com.vfs.casadocodigoapi.domain.services

import br.com.vfs.casadocodigoapi.domain.entities.Author
import br.com.vfs.casadocodigoapi.domain.entities.NewAuthor

interface AuthorService {
    /*
        meu caso de uso é criar um novo autor
     */
    fun create(newAuthor: NewAuthor): Author

    fun findAll(): List<Author>

    fun findById(id: Long): Author
}