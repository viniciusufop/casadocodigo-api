package br.com.vfs.casadocodigoapi.model.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "AUTHOR")
@EntityListeners(AuditingEntityListener::class)
data class Author(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Long? = null,
    @Column(name = "EMAIL")
    val email: String,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "DESCRIPTION")
    val description: String,
    @CreatedDate
    @Column(name = "CREATED_AT")
    var createdAt: LocalDateTime? = null //mutavel por causa do framework
)
