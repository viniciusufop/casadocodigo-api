package br.com.vfs.casadocodigoapi.repository

import br.com.vfs.casadocodigoapi.model.entity.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : CrudRepository<Author, Long> {
}