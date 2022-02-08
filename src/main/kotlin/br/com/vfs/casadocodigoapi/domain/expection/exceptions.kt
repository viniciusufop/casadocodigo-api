package br.com.vfs.casadocodigoapi.domain.expection

open class AuthorException(override val message:String) : RuntimeException(message)

class AuthorExistsInSystemException(email: String) : AuthorException("Author $email exists in system")

class AuthorDoNotExistException(id: Long) : AuthorException("Author $id don't exist in system")