package br.com.vfs.casadocodigoapi.infrastructure.resource.validator

import br.com.vfs.casadocodigoapi.infrastructure.resource.validator.annotations.UniqueValue
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class UniqueValueValidator(
    private var fieldName: String? = null,
    private var clazz: KClass<*>? = null,
    @field:PersistenceContext
    private var entityManager: EntityManager
) : ConstraintValidator<UniqueValue, Any?> {

    override fun initialize(constraintAnnotation: UniqueValue) {
        fieldName = constraintAnnotation.fieldName
        clazz = constraintAnnotation.domainClass
    }

    override fun isValid(value: Any?, context: ConstraintValidatorContext?): Boolean {
        if(value == null) return true
        val query = entityManager.createQuery("select 1 from ${clazz!!.simpleName} where $fieldName=:value")
        query.setParameter("value", value)
        val result = query.resultList
        return result.isEmpty()
    }
}