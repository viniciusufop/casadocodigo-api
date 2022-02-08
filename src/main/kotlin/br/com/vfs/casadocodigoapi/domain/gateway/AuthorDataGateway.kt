package br.com.vfs.casadocodigoapi.domain.gateway

import br.com.vfs.casadocodigoapi.domain.model.Author
import br.com.vfs.casadocodigoapi.domain.input.NewAuthor

interface AuthorDataGateway {

    fun save(author: Author): Author
    fun findAll(): List<Author>
    fun findById(id: Long) : Author?
    fun findByEmail(email: String): Author?
}