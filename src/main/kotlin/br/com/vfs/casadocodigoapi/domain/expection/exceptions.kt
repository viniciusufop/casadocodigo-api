package br.com.vfs.casadocodigoapi.domain.expection

open class AuthorException(message:String) : RuntimeException(message)

class AuthorExistsInSystemException(email: String) : AuthorException("Author $email exists in system")
