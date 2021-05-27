package br.com.vfs.casadocodigoapi.domain.gateway

import br.com.vfs.casadocodigoapi.domain.entities.Author
import br.com.vfs.casadocodigoapi.domain.entities.NewAuthor

interface AuthorDataGateway {

    fun create(newAuthor: NewAuthor): Author
    fun findAll(): List<Author>
    fun findById(id: Long) : Author?
}