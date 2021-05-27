package br.com.vfs.casadocodigoapi.infrastructure.resource.handler

import br.com.vfs.casadocodigoapi.expection.ElementNotExistException
import br.com.vfs.casadocodigoapi.infrastructure.resource.commons.ErrorModel
import org.springframework.core.env.Environment
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
class ErrorHandler(private val environment: Environment) : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errors = ex.bindingResult.fieldErrors
            .map { "field: ${it.field}, message: ${environment.getProperty(it.defaultMessage?:"")}, value: ${it.rejectedValue}"}
        val url = (request as ServletWebRequest).request.requestURI
        val errorModel = ErrorModel(errors = errors, path = url)
        return super.handleExceptionInternal(ex, errorModel, headers, status, request)
    }

    @ExceptionHandler(value = [ElementNotExistException::class])
    fun handle(ex: ElementNotExistException, request: WebRequest):ResponseEntity<Any> {
        val errors = listOf(ex.message)
        val url = (request as ServletWebRequest).request.requestURI
        val errorModel = ErrorModel(errors = errors, path = url)
        return super.handleExceptionInternal(ex, errorModel, HttpHeaders.EMPTY, HttpStatus.NOT_FOUND, request)
    }
}