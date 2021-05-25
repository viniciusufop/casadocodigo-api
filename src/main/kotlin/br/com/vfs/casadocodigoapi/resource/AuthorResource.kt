package br.com.vfs.casadocodigoapi.resource

import br.com.vfs.casadocodigoapi.model.entity.Author
import br.com.vfs.casadocodigoapi.model.request.AuthorRequest
import br.com.vfs.casadocodigoapi.model.response.AuthorResponse
import br.com.vfs.casadocodigoapi.service.AuthorService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/authors")
class AuthorResource (private val service: AuthorService) {

    @PostMapping
    fun createAuthor(@RequestBody @Valid request: AuthorRequest): AuthorResponse {
        val author = service.create(Author(
            email = request.email,
            name = request.name,
            description = request.description
        ))
        return AuthorResponse(author.id, author.email, author.name, author.description, author.createdAt)
    }

    @GetMapping
    fun findAll() = service.findAll()
            .map { AuthorResponse(it.id, it.email, it.name, it.description, it.createdAt)}

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): AuthorResponse {
        val author = service.findById(id)
        return AuthorResponse(author.id, author.email, author.name, author.description, author.createdAt)
    }
}