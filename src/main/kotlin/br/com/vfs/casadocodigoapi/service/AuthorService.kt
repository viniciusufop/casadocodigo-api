package br.com.vfs.casadocodigoapi.service

import br.com.vfs.casadocodigoapi.model.entity.Author

interface AuthorService {

    fun create(author: Author): Author
}