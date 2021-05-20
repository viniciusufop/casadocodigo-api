package br.com.vfs.casadocodigoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
