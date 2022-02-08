package br.com.vfs.casadocodigoapi.infrastructure.resource.handler

import br.com.vfs.casadocodigoapi.domain.expection.AuthorDoNotExistException
import br.com.vfs.casadocodigoapi.domain.expection.AuthorException
import br.com.vfs.casadocodigoapi.infrastructure.resource.commons.ErrorModel
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ErrorHandle : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errors = ex.bindingResult.fieldErrors
            .map { "field: ${it.field}, message: ${it.defaultMessage?: ""}, value: ${it.rejectedValue}"}
        val url = (request as ServletWebRequest).request.requestURI
        val errorModel = ErrorModel(errors = errors, path = url)
        return super.handleExceptionInternal(ex, errorModel, headers, status, request)
    }

    @ExceptionHandler(value = [AuthorException::class])
    fun handleAuthorException(ex: AuthorException, request: WebRequest):ResponseEntity<Any> {
        val errors = listOf(ex.message)
        val url = (request as ServletWebRequest).request.requestURI
        val errorModel = ErrorModel(errors = errors, path = url)
        return super.handleExceptionInternal(ex, errorModel, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, request)
    }

    @ExceptionHandler(value = [AuthorDoNotExistException::class])
    fun handleAuthorDoNotExistException(ex: AuthorDoNotExistException, request: WebRequest):ResponseEntity<Any> {
        val errors = listOf(ex.message)
        val url = (request as ServletWebRequest).request.requestURI
        val errorModel = ErrorModel(errors = errors, path = url)
        return super.handleExceptionInternal(ex, errorModel, HttpHeaders.EMPTY, HttpStatus.NOT_FOUND, request)
    }
}