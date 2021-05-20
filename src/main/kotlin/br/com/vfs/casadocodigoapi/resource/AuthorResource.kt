package br.com.vfs.casadocodigoapi.resource

import br.com.vfs.casadocodigoapi.model.entity.Author
import br.com.vfs.casadocodigoapi.model.request.AuthorRequest
import br.com.vfs.casadocodigoapi.model.response.AuthorResponse
import br.com.vfs.casadocodigoapi.service.AuthorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authors")
class AuthorResource (private val service: AuthorService) {

    @PostMapping
    fun createAuthor(@RequestBody request: AuthorRequest): AuthorResponse {
        val author = service.create(Author(
            email = request.email,
            name = request.name,
            description = request.description
        ))
        return AuthorResponse(author.id!!, author.email, author.name, author.description, author.createdAt)
    }
}