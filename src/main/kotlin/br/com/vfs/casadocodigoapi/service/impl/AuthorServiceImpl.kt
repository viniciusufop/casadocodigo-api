package br.com.vfs.casadocodigoapi.service.impl

import br.com.vfs.casadocodigoapi.model.entity.Author
import br.com.vfs.casadocodigoapi.repository.AuthorRepository
import br.com.vfs.casadocodigoapi.service.AuthorService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class AuthorServiceImpl(private val repository: AuthorRepository) : AuthorService {

    @Transactional
    override fun create(author: Author) = repository.save(author)
}