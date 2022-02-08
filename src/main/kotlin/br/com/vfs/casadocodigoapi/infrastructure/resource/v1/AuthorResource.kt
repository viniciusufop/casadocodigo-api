package br.com.vfs.casadocodigoapi.infrastructure.resource.v1

import br.com.vfs.casadocodigoapi.domain.usecase.AuthorService
import br.com.vfs.casadocodigoapi.domain.usecase.CreateAuthorUseCase
import br.com.vfs.casadocodigoapi.infrastructure.resource.v1.request.AuthorRequest
import br.com.vfs.casadocodigoapi.infrastructure.resource.v1.response.AuthorResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/authors")
class AuthorResource (
    private val service: AuthorService,
    private val createAuthorUseCase: CreateAuthorUseCase
    ) {

    @PostMapping
    fun createAuthor(@RequestBody @Valid request: AuthorRequest) =
        request.toInput()
            .let { createAuthorUseCase.execute(it) }
            .let { AuthorResponse(it) }

    @GetMapping
    fun findAll() = service.findAll()
            .map {AuthorResponse(it.id, it.email, it.name, it.description, it.createdAt)}

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): AuthorResponse {
        val author = service.findById(id)
        return AuthorResponse(author.id, author.email, author.name, author.description, author.createdAt)
    }
}