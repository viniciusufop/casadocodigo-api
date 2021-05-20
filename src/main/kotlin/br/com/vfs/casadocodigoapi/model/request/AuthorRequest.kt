package br.com.vfs.casadocodigoapi.model.request

data class AuthorRequest(
    val email: String,
    val name: String,
    val description: String,
)
