package br.com.vfs.casadocodigoapi.validator.annotations

import br.com.vfs.casadocodigoapi.validator.UniqueValueValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Constraint(validatedBy = [UniqueValueValidator::class])
annotation class UniqueValue(
    val message:String = "br.com.vfs.api.casadocodigo.bean-validation.unique-value",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val fieldName: String,
    val domainClass: KClass<*>
)
