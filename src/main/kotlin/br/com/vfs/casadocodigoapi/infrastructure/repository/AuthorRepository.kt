package br.com.vfs.casadocodigoapi.infrastructure.repository

import br.com.vfs.casadocodigoapi.infrastructure.repository.model.AuthorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<AuthorEntity, Long> {

    fun findByEmail(email: String): AuthorEntity?
}