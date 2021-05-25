package br.com.vfs.casadocodigoapi.expection

class ElementNotExistException(override val message: String) : RuntimeException(message)

class InvalidConfigurationException(override val message: String) : RuntimeException(message)