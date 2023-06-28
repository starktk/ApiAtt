package br.com.fundatec.fundatecheroesti21.login.data.repositoty

import android.util.Log
import br.com.fundatec.fundatecheroesti21.database.FHDatabase
import br.com.fundatec.fundatecheroesti21.login.data.local.UserEntity
import br.com.fundatec.fundatecheroesti21.login.data.remote.LoginResponse
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository {
    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }

    private val client =
        RetrofitNetworkClient
            .createNetworkClient()
            .create(LoginService::class.java)

    suspend fun login(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = client.getUser(email, password)
                saveUser(response)
                response.isSuccessful
            } catch (exception: Exception) {
                Log.e("login", exception.message.orEmpty())
                false
            }
        }
    }

    private suspend fun saveUser(user: Response<LoginResponse>) {
        return withContext(Dispatchers.IO) {
            if (user.isSuccessful) {
                user.body()?.run {
                    database.userDao().insertUser(
                        userResponseToEntity()
                    )
                }
            }
        }
    }

    private fun LoginResponse.userResponseToEntity(): UserEntity {
        return UserEntity(
            name = name,
            email = email,
            password = password,
        )
    }

}