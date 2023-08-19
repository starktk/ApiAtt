package br.com.fundatec.fundatecheroesti21.login.domain

import br.com.fundatec.fundatecheroesti21.login.data.repository.LoginRepository

class LoginUseCase {
    private val repository by lazy { LoginRepository() }

    suspend fun login(email: String, password: String): Boolean {
        return repository.login(email = email, password = password)
    }
    suspend fun verifyTimeLogCache() {
        repository.validateCache()
    }
    suspend fun verifyUserExist(): Boolean {
       return repository.userCheckExists();
    }
    suspend fun createUser(name: String, email: String, password: String): Boolean {
        return repository.createUser(name, email, password)
    }
    suspend fun getIdUser(): Int {
        val id: Int = repository.getUsuario()
        return id
    }
}