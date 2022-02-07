package br.com.vfs.casadocodigoapi.infrastructure.resource.v1

import br.com.vfs.casadocodigoapi.domain.input.NewAuthor
import br.com.vfs.casadocodigoapi.domain.usecase.AuthorService
import br.com.vfs.casadocodigoapi.infrastructure.resource.v1.request.AuthorRequest
import br.com.vfs.casadocodigoapi.infrastructure.resource.v1.response.AuthorResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/authors")
class AuthorResource (private val service: AuthorService) {

    @PostMapping
    fun createAuthor(@RequestBody @Valid request: AuthorRequest): AuthorResponse {
        val author = service.create(
            NewAuthor(
            email = request.email,
            name = request.name,
            description = request.description
        )
        )
        return AuthorResponse(author.id, author.email, author.name, author.description, author.createdAt)
    }

    @GetMapping
    fun findAll() = service.findAll()
            .map {AuthorResponse(it.id, it.email, it.name, it.description, it.createdAt)}

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): AuthorResponse {
        val author = service.findById(id)
        return AuthorResponse(author.id, author.email, author.name, author.description, author.createdAt)
    }
}