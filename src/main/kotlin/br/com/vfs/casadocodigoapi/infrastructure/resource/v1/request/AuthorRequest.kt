package br.com.vfs.casadocodigoapi.infrastructure.resource.v1.request

import br.com.vfs.casadocodigoapi.domain.input.NewAuthor
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AuthorRequest(
    @field:NotBlank
    @field:Email
    val email: String?,
    @field:NotBlank
    @field:Size(max = 200)
    val name: String?,
    @field:NotBlank
    @field:Size(max = 400)
    val description: String?
) {
    fun toInput() =
        NewAuthor(
            email = this.email!!,
            name = this.name!!,
            description = this.description!!
        )
}
