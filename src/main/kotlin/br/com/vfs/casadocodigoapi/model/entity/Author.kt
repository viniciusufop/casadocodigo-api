package br.com.vfs.casadocodigoapi.model.entity

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Author(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "EMAIL")
    val email: String,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "DESCRIPTION")
    val description: String,
    @CreatedDate
    @Column(name = "CREATED_AT")
    val createdAt: LocalDateTime = LocalDateTime.now()
)
