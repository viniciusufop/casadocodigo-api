package br.com.vfs.casadocodigoapi.model.request

import br.com.vfs.casadocodigoapi.model.entity.Author
import br.com.vfs.casadocodigoapi.validator.annotations.UniqueValue
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AuthorRequest(
    @get:NotBlank
    @get:Email
    @get:UniqueValue(fieldName = "email", domainClass = Author::class)
    val email: String,
    @get:NotBlank
    val name: String,
    @get:NotBlank
    @get:Size(max = 400)
    val description: String,
)
