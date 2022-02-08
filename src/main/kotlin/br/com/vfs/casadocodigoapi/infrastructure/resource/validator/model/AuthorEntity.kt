package br.com.vfs.casadocodigoapi.infrastructure.resource.validator.model

import br.com.vfs.casadocodigoapi.domain.model.Author
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "AUTHOR")
@EntityListeners(AuditingEntityListener::class)
data class AuthorEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long = 0,
    @Column(name = "EMAIL")
    val email: String,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "DESCRIPTION")
    val description: String,
    @CreatedDate
    @Column(name = "CREATED_AT")
    var createdAt: LocalDateTime = LocalDateTime.now()
) {
    constructor(author: Author) : this(
        email = author.email,
        name = author.name,
        description = author.description
    )

    fun toModel() =
        Author(
            id = id,
            email = email,
            name = name,
            description = description,
            createdAt = createdAt
        )
}
