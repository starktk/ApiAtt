package br.com.fundatec.fundatecheroesti21.login.data.repository

import android.util.Log
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository {

    private val client by lazy {
        RetrofitNetworkClient.createNetworkClient("https://fundatec.herokuapp.com").
        create(LoginService::class.java)
    }
    suspend fun login(email: String, password: String): Boolean {
        return withContext<Boolean>(Dispatchers.IO) {
            try {
                client.getUser(email, password)
                true
            } catch (exception: Exception) {
                Log.e("Login", exception.message.orEmpty())
                false
            }
        }
    }
}