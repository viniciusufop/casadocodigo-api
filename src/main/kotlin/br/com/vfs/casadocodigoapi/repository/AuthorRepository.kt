package br.com.vfs.casadocodigoapi.repository

import br.com.vfs.casadocodigoapi.model.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Long> {
}