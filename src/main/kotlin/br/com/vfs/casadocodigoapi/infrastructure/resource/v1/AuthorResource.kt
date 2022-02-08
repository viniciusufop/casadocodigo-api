package br.com.vfs.casadocodigoapi.infrastructure.resource.v1

import br.com.vfs.casadocodigoapi.domain.usecase.CreateAuthorUseCase
import br.com.vfs.casadocodigoapi.domain.usecase.FindAllAuthorsUseCase
import br.com.vfs.casadocodigoapi.domain.usecase.FindByIdAuthorUserCase
import br.com.vfs.casadocodigoapi.infrastructure.resource.v1.request.AuthorRequest
import br.com.vfs.casadocodigoapi.infrastructure.resource.v1.response.AuthorResponse
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/authors")
class AuthorResource (
    private val createAuthorUseCase: CreateAuthorUseCase,
    private val findAllAuthorsUseCase: FindAllAuthorsUseCase,
    private val findByIdAuthorUserCase: FindByIdAuthorUserCase
    ) {

    @ResponseStatus(CREATED)
    @PostMapping
    fun createAuthor(@RequestBody @Valid request: AuthorRequest) =
        request.toInput()
            .let { createAuthorUseCase.execute(it) }
            .let { AuthorResponse(it) }

    @GetMapping
    fun findAll() = findAllAuthorsUseCase.execute().map { AuthorResponse(it) }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long) =
        AuthorResponse(findByIdAuthorUserCase.execute(id))
}